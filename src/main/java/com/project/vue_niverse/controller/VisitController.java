package com.project.vue_niverse.controller;

import com.project.vue_niverse.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/visit")
public class VisitController {
    private static final Logger _log = LoggerFactory.getLogger(VisitController.class);

    private final VisitService visitService;


    // 전제 방문자수 조회
    @GetMapping
    public int countVisits() {
        return visitService.countVisits();
    }

    @PutMapping
    public int updateVisits() {
        visitService.plusVisits();
        return visitService.countVisits();

    }


}
