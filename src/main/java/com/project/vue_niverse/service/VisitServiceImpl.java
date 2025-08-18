package com.project.vue_niverse.service;

import com.project.vue_niverse.controller.VisitController;
import com.project.vue_niverse.dto.VisitDto;
import com.project.vue_niverse.mapper.BoardMapper;
import com.project.vue_niverse.mapper.VisitMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class VisitServiceImpl implements VisitService {
    private static final Logger _log = LoggerFactory.getLogger(VisitServiceImpl.class);

    private final VisitMapper visitMapper;
    public VisitServiceImpl(VisitMapper visitMapper) {
        this.visitMapper = visitMapper;
    }

    @Override
    public int countVisits() {
        return visitMapper.countVisits();
    }

    @Override
    public int plusVisits(int visits) {
        return visitMapper.plusVisits(++visits);
    }
}
