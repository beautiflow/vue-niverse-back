package com.project.vue_niverse.mapper;

import com.project.vue_niverse.dto.LineDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LineMapperTest {

    @Autowired
    LineMapper lineMapper;

    @Test
    @DisplayName("lineString 저장")
    @Transactional
    void saveLine4326() {
        // given
        LineDto lineDto = new LineDto();
        lineDto.setName("testLine");
        lineDto.setGeom("LINESTRING(88.25955669771925 0.9164568730770384,106.76260841631866 0.9164568730770384,95.10568583360103 -36.18799295525798,95.845807902345 -20.29430202978908)");

        // when
        int success = lineMapper.saveLine4326(lineDto);

        // then
        assertTrue(success > 0);
    }
}