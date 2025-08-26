package com.project.vue_niverse.service;

import com.project.vue_niverse.dto.LineDto;
import com.project.vue_niverse.mapper.LineMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LineServiceImpl implements LineService {
    private final LineMapper lineMapper;

    @Transactional
    @Override
    public int saveLine(LineDto lineDto) {
        return lineMapper.saveLine4326(lineDto);
    }
}
