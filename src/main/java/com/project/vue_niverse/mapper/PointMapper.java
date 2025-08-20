package com.project.vue_niverse.mapper;

import com.project.vue_niverse.dto.PointDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PointMapper {
    int savePoint(PointDto pointDto);
}
