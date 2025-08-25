package com.project.vue_niverse.mapper;

import com.project.vue_niverse.dto.PolygonDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PolygonMapper {
    int savePolygon4326(PolygonDto pointDto);
    int savePolygon3857(PolygonDto polygonDto);

}
