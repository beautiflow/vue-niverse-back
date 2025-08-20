package com.project.vue_niverse.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PointDto {

    long id;

    @Setter
    String name;

    @Setter
    String geom;

    @Setter
    LocalDateTime createdAt;

    @Setter
    LocalDateTime updatedAt;

}
