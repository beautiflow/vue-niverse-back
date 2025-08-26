package com.project.vue_niverse.controller;

import com.project.vue_niverse.dto.LineDto;
import com.project.vue_niverse.service.LineService;
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
@RequestMapping("/line")
public class LineController {

    private final LineService lineService;
    private static final Logger _log = LoggerFactory.getLogger(LineController.class);

    @PostMapping
    public ResponseEntity<Integer> saveLine(@RequestBody LineDto lineDto) {
        _log.info("request to save line {}", lineDto.getName());

        try {
            int saved = lineService.saveLine(lineDto);
            if (saved == 1) {
                _log.info("saved line {}", saved);
                return ResponseEntity.status(HttpStatus.CREATED).body(saved);
            } else {
                _log.warn("Polygon creation failed (affected rows: {}) with title: {}", saved, lineDto.getName());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .build();
            }
        }catch (Exception e){
            _log.error("Exception occurred while saving line with title: {}", lineDto.getName(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
