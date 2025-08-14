package com.project.vue_niverse.service;

import com.project.vue_niverse.dto.BoardDto;
import com.project.vue_niverse.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;
    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public int createBoard(BoardDto boardDto) {
        int success = boardMapper.insertBoard(boardDto);
        if (success == 1) {
            return success;
        }
        return -1;
    }

    @Override
    public List<BoardDto> findAll(){
        return boardMapper.findAll();
    }

}
