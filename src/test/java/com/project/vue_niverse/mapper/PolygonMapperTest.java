package com.project.vue_niverse.mapper;

import com.project.vue_niverse.dto.PolygonDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PolygonMapperTest {

    @Autowired
    PolygonMapper polygonMapper;

    @Test
    @DisplayName("polygon 저장")
    @Transactional
    void savePolygon4326() {
        // given
        PolygonDto polygonDto = new PolygonDto();
        polygonDto.setName("testPolygon");
        polygonDto.setGeom("POLYGON((127.21935882627737 36.56080298915646,127.22960933056 36.42070483904048,127.37995006003837 36.419330073754935,127.40728473812531 36.558058402779395,127.21935882627737 36.56080298915646))");

        // when
        int success = polygonMapper.savePolygon4326(polygonDto);

        // then
        assertTrue(success > 0);
    }

}