package com.project.vue_niverse.service;

import com.project.vue_niverse.dto.BoardDto;

import java.util.List;

public interface BoardService {

    int createBoard(BoardDto boardDto);

    List<BoardDto> findAll();

    BoardDto getBoard(long id);

    BoardDto updateBoard(long id, BoardDto boardDto);

    void deleteBoard(long id);
}
