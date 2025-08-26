package com.project.vue_niverse.controller;

import com.project.vue_niverse.service.VisitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/visit")
public class VisitController {
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
