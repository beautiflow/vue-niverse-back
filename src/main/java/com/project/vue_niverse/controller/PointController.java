package com.project.vue_niverse.controller;

import com.project.vue_niverse.dto.BoardDto;
import com.project.vue_niverse.dto.PointDto;
import com.project.vue_niverse.service.PointService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/point")
public class PointController {

    private final PointService pointService;
    private static final Logger _log = LoggerFactory.getLogger(PointController.class);

    // 포인트 저장
    @PostMapping
    public ResponseEntity<Integer> savePoint(@RequestBody PointDto pointDto) {
        try {
            _log.info("name = " + pointDto.getName() );
            _log.info( "getGeom = " + pointDto.getGeom());
            int saved = pointService.savePoint(pointDto);

            if (saved == 1) {
                return ResponseEntity.status(HttpStatus.CREATED).body(saved);
            } else {
                _log.warn("Point creation failed (affected rows: {}) with title: {}", saved, pointDto.getName());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .build();
            }
        }
        catch (Exception e) {
            _log.error("Exception occurred while saving point with title: {}", pointDto.getName(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }

    }

}
