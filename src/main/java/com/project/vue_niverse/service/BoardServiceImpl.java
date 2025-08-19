package com.project.vue_niverse.service;

import com.project.vue_niverse.dto.BoardDto;
import com.project.vue_niverse.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
//    private static final Logger _log = LoggerFactory.getLogger(BoardServiceImpl.class);

    private final BoardMapper boardMapper;

    @Transactional
    @Override
    public int createBoard(BoardDto boardDto) {
        return boardMapper.insertBoard(boardDto);
    }

    @Override
    public List<BoardDto> findAll(){
        return boardMapper.findAll();
    }

    @Override
    public BoardDto getBoard(long id) {
        BoardDto existDto = boardMapper.findById(id);
        if (existDto == null) {
            throw new NoSuchElementException("Board with id " + id + " not found");
        }
        return existDto;
    }

    @Transactional
    @Override
    public BoardDto updateBoard(long id, BoardDto boardDto) {
        getBoard(id);
        int result = boardMapper.updateBoard(id, boardDto);
        if (result > 0) {
            return boardMapper.findById(id);
        }
        throw new IllegalStateException("Update failed for board id: " + id);
    }

    @Transactional
    @Override
    public void deleteBoard(long id) {
        getBoard(id);
        boardMapper.deleteBoard(id);
    }

}
