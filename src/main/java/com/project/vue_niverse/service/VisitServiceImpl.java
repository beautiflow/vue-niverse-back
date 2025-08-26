package com.project.vue_niverse.service;

import com.project.vue_niverse.mapper.VisitMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class VisitServiceImpl implements VisitService {

    private final VisitMapper visitMapper;

    @Override
    public int countVisits() {
        return visitMapper.countVisits();
    }

    @Transactional
    @Override
    public void plusVisits() {
        visitMapper.plusVisits();
    }
}
