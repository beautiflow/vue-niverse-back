package com.project.vue_niverse.controller;

import com.project.vue_niverse.dto.BoardDto;
import com.project.vue_niverse.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    private static final Logger _log = LoggerFactory.getLogger(BoardController.class);

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 게시판 전체 조회
    @GetMapping
    public ResponseEntity<Object> findAll() {
        List<BoardDto> boards = boardService.findAll();
        if (boards.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(boards);
    }

    // 게시판 생성
    @PostMapping
    public ResponseEntity<Integer> createBoard(@RequestBody BoardDto boardDto) {
        int created = boardService.createBoard(boardDto);
        if (created != 1) {
            _log.warn("Failed to create board with title: {}", boardDto.getTitle());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // 게시판 단일 조회
    @GetMapping("/{id}")
    public ResponseEntity<BoardDto> getBoardById(@PathVariable long id) {
        BoardDto board  = boardService.getBoard(id);
        if (board == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(board);
    }

    // 게시판 수정
    @PutMapping("/{id}")
    public ResponseEntity<BoardDto> updateBoard(@PathVariable long id, @RequestBody BoardDto boardDto) {
        BoardDto update = boardService.updateBoard(id, boardDto);
        if (update == null) {
            _log.warn("Failed to update board with ID: {}", id);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(update);
    }
}
