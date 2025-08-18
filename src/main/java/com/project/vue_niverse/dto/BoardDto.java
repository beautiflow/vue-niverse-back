package com.project.vue_niverse.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@NoArgsConstructor
@Setter
@Getter
public class BoardDto {

    private long id;

    private String title;

    private String content;

    private String author;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
