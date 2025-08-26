package com.project.vue_niverse.service;

import com.project.vue_niverse.dto.PointDto;
import com.project.vue_niverse.mapper.PointMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PointServiceImpl implements PointService {
    private final PointMapper pointMapper;

    @Transactional
    @Override
    public int savePoint(PointDto pointDto) {

        return pointMapper.savePoint(pointDto);
    }
}
