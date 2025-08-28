package com.project.vue_niverse.mapper;

import com.project.vue_niverse.dto.PointDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PointMapperTest {

    @Autowired
    PointMapper pointMapper;

    @Test
    @DisplayName("point 저장")
    @Transactional
    void savePoint() {
        // given
        PointDto point = new PointDto();
        point.setName("testPoint");
        point.setGeom("POINT(127.39190898170139 36.34092823414295)");

        // when
        int success = pointMapper.savePoint(point);

        // then
        assertTrue(success > 0);

    }
}