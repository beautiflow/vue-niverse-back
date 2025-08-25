package com.project.vue_niverse.controller;

import com.project.vue_niverse.dto.PolygonDto;
import com.project.vue_niverse.service.PolygonService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        int saved = polygonService.savePolygon(polygonDto);
        _log.info("saved polygon {}", saved);
        return null;
    }
}
