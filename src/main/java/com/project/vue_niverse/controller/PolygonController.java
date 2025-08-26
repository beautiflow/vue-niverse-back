package com.project.vue_niverse.controller;

import com.project.vue_niverse.dto.PolygonDto;
import com.project.vue_niverse.service.PolygonService;
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
@RequestMapping("/polygon")
public class PolygonController {

    private final PolygonService polygonService;
    private static final Logger _log = LoggerFactory.getLogger(PolygonController.class);

    // polygon 저장
    @PostMapping
    public ResponseEntity<Integer> savePolygon(@RequestBody PolygonDto polygonDto) {
        _log.info("Saving polygon {}", polygonDto);

        _log.info("Saving polygon {}", polygonDto.getName());
        _log.info("Saving polygon {}", polygonDto.getGeom());
        try {
            int saved = polygonService.savePolygon(polygonDto);
            if (saved == 1) {
                _log.info("saved polygon {}", saved);
                return ResponseEntity.status(HttpStatus.CREATED).body(saved);
            } else {
                _log.warn("Polygon creation failed (affected rows: {}) with title: {}", saved, polygonDto.getName());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .build();
            }
        }catch (Exception e){
            _log.error("Exception occurred while saving polygon with title: {}", polygonDto.getName(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
