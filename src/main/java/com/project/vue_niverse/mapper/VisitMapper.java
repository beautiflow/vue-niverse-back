package com.project.vue_niverse.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VisitMapper {

    int countVisits();

    void plusVisits();
}
