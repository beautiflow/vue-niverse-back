package com.project.vue_niverse.service;

import com.project.vue_niverse.dto.BoardDto;
import com.project.vue_niverse.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
    private static final Logger _log = LoggerFactory.getLogger(BoardServiceImpl.class);

    private final BoardMapper boardMapper;

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
        int result = boardMapper.updateBoard(id, boardDto);

        if (result > 0) {
            return boardMapper.findById(id);
        }
        return null;
    }

    @Override
    public void deleteBoard(long id) {
        boardMapper.deleteBoard(id);
    }

}
