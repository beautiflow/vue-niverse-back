package com.project.vue_niverse.controller;

import com.project.vue_niverse.dto.PointDto;
import com.project.vue_niverse.service.PointService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/point")
public class PointController {

    private final PointService pointService;

    // 포인트 저장
    @PostMapping
    public ResponseEntity<Integer> savePoint(@RequestBody PointDto pointDto) {
        try {
            log.info("name = " + pointDto.getName() );
            log.info( "getGeom = " + pointDto.getGeom());
            int saved = pointService.savePoint(pointDto);

            if (saved == 1) {
                return ResponseEntity.status(HttpStatus.CREATED).body(saved);
            } else {
                log.warn("Point creation failed (affected rows: {}) with title: {}", saved, pointDto.getName());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .build();
            }
        }
        catch (Exception e) {
            log.error("Exception occurred while saving point with title: {}", pointDto.getName(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }

    }

}
