package com.project.vue_niverse.service;

import com.project.vue_niverse.dto.BoardDto;
import com.project.vue_niverse.mapper.BoardMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    private static final Logger _log = LoggerFactory.getLogger(BoardServiceImpl.class);

    private final BoardMapper boardMapper;
    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public int createBoard(BoardDto boardDto) {
        int success = boardMapper.insertBoard(boardDto);
        if (success > 0) {
            return success;
        }
        return -1;
    }

    @Override
    public List<BoardDto> findAll(){
        return boardMapper.findAll();
    }

    @Override
    public BoardDto getBoard(long id) {
        return boardMapper.findById(id);
    }

    @Override
    public BoardDto updateBoard(long id, BoardDto boardDto) {
        boardDto.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        int result = boardMapper.updateBoard(id, boardDto);

        if (result > 0) {
            return boardMapper.findById(id);
        }
        return null;
    }

}
