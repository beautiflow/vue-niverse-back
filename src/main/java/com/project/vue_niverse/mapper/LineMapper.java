package com.project.vue_niverse.mapper;

import com.project.vue_niverse.dto.LineDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LineMapper {
    int saveLine4326(LineDto lineDto);

}
