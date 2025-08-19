package com.project.vue_niverse.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BoardDto {

    long id;

    @Setter
    String title;

    @Setter
    String content;

    @Setter
    String author;

    @Setter
    LocalDateTime createdAt;

    @Setter
    LocalDateTime updatedAt;
}
