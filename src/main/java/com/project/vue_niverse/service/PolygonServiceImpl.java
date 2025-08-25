package com.project.vue_niverse.service;

import com.project.vue_niverse.dto.PolygonDto;
import com.project.vue_niverse.mapper.PolygonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PolygonServiceImpl implements PolygonService {

    private final PolygonMapper polygonMapper;

    @Transactional
    @Override
    public int savePolygon(PolygonDto polygonDto) {
        return polygonMapper.savePolygon4326(polygonDto);
    }

// 프론트에서 3857 로 받아와서 db에서 4326 으로 변환하는 방법
//    @Transactional
//    @Override
//    public int savePolygon(PolygonDto polygonDto) {
//        return polygonMapper.savePolygon3857(polygonDto);
//    }
}
