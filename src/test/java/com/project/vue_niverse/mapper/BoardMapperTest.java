package com.project.vue_niverse.mapper;

import com.project.vue_niverse.dto.BoardDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    void selectBoardById() {
        List<BoardDto> all = boardMapper.findAll();
        System.out.println(all);
        assertEquals(4, all.size());
    }

    @Test
    @DisplayName("게시글 저장")
    @Transactional
    void insertBoard() {
        //given
        BoardDto boardDto = new BoardDto();
        boardDto.setAuthor("testAuthor");
        boardDto.setTitle("testTitle");
        boardDto.setContent("testContent");

        // when
        int success = boardMapper.insertBoard(boardDto);

        // then
        assertTrue(success > 0);
    }

    @Test
    @DisplayName("게시글 수정")
    @Transactional
    void updateBoard() {
        // given
        BoardDto boardDto = boardMapper.findById(1);
        assertNotNull(boardDto);
        boardDto.setTitle("updateTitle");
        boardDto.setContent("updateContent");

        //when
        int success = boardMapper.updateBoard(1, boardDto);

        //then
        assertTrue(success > 0);

        BoardDto updated = boardMapper.findById(1);
        assertEquals("updateTitle", updated.getTitle());
        assertEquals("updateContent", updated.getContent());
    }

    @Test
    @DisplayName("게시글 삭제")
    @Transactional
    void deleteBoard() {
        // given
        BoardDto boardDto = boardMapper.findById(1);
        assertNotNull(boardDto);

        // when
        boardMapper.deleteBoard(1);

        // then
        assertNull(boardMapper.findById(1));
    }

    @Test
    @DisplayName("게시글 단일 조회")
    @Transactional
    void findById() {
        BoardDto boardDto = boardMapper.findById(1);
        assertNotNull(boardDto);
    }

    @Test
    @DisplayName("게시글 전체 조회")
    @Transactional
    void findAll() {
        List<BoardDto> all = boardMapper.findAll();
        assertEquals(5, all.size());
    }

}