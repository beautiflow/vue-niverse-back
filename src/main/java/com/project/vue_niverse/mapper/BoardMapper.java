package com.project.vue_niverse.mapper;

import com.project.vue_niverse.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    int insertBoard(BoardDto boardDto);

    List<BoardDto> findAll();

    BoardDto findById(long id);

    int updateBoard(@Param("id") long id, @Param("boardDto") BoardDto boardDto);
}
