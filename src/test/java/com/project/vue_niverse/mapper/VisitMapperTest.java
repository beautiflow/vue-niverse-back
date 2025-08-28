package com.project.vue_niverse.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VisitMapperTest {

    @Autowired
    VisitMapper visitMapper;

    @Test
    @DisplayName("방문자 수 조회")
    @Transactional
    void countVisits() {
        // given
        visitMapper.plusVisits();

        //when
        visitMapper.countVisits();

        // then
        assertTrue(visitMapper.countVisits() > 0);

    }

    @Test
    @DisplayName("방문자 수 증가")
    @Transactional
    void plusVisits() {
        // given
        int count = visitMapper.countVisits();

        // when
        visitMapper.plusVisits();
        int plusCount = visitMapper.countVisits();

        // then
        assertTrue(plusCount > count);
    }
}