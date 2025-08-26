package com.project.vue_niverse.controller;

import com.project.vue_niverse.dto.BoardDto;
import com.project.vue_niverse.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    // 게시판 전체 조회
    @GetMapping
    public ResponseEntity<List<BoardDto>> findAll() {
        List<BoardDto> boards = boardService.findAll();
        return ResponseEntity.ok(boards);
    }

    // 게시판 생성
    @PostMapping
    public ResponseEntity<Integer> createBoard(@RequestBody BoardDto boardDto) {
        try {
            int created = boardService.createBoard(boardDto);

            if (created == 1) {
                return ResponseEntity.status(HttpStatus.CREATED).body(created);
            } else {
                log.warn("Board creation failed (affected rows: {}) with title: {}", created, boardDto.getTitle());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .build();
            }
        }
        catch (Exception e) {
            log.error("Exception occurred while creating board with title: {}", boardDto.getTitle(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    // 게시판 단일 조회
    @GetMapping("/{id}")
    public ResponseEntity<BoardDto> getBoardById(@PathVariable long id) {
        try {
            BoardDto board  = boardService.getBoard(id);
            return ResponseEntity.ok(board);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // 게시판 수정
    @PutMapping("/{id}")
    public ResponseEntity<BoardDto> updateBoard(@PathVariable long id, @RequestBody BoardDto boardDto) {
        try{
            BoardDto update = boardService.updateBoard(id, boardDto);
            return ResponseEntity.ok(update);
        }catch(Exception e) {
            log.warn("Failed to update board with ID: {}", id);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // 게시판 삭제
    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable long id) {
        boardService.deleteBoard(id);
    }
}
