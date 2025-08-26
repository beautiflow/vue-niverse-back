package com.project.vue_niverse.controller;

import com.project.vue_niverse.dto.PolygonDto;
import com.project.vue_niverse.service.PolygonService;
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
@RequestMapping("/polygon")
public class PolygonController {

    private final PolygonService polygonService;

    // polygon 저장
    @PostMapping
    public ResponseEntity<Integer> savePolygon(@RequestBody PolygonDto polygonDto) {
        log.info("Saving polygon {}", polygonDto);

        log.info("Saving polygon {}", polygonDto.getName());
        log.info("Saving polygon {}", polygonDto.getGeom());
        try {
            int saved = polygonService.savePolygon(polygonDto);
            if (saved == 1) {
                log.info("saved polygon {}", saved);
                return ResponseEntity.status(HttpStatus.CREATED).body(saved);
            } else {
                log.warn("Polygon creation failed (affected rows: {}) with title: {}", saved, polygonDto.getName());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .build();
            }
        }catch (Exception e){
            log.error("Exception occurred while saving polygon with title: {}", polygonDto.getName(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
