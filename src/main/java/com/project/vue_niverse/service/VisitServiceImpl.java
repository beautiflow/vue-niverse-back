package com.project.vue_niverse.service;

import com.project.vue_niverse.mapper.VisitMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VisitServiceImpl implements VisitService {
    private static final Logger _log = LoggerFactory.getLogger(VisitServiceImpl.class);

    private final VisitMapper visitMapper;

    @Override
    public int countVisits() {
        return visitMapper.countVisits();
    }

    @Override
    public int plusVisits() {
        return visitMapper.plusVisits();
    }
}
