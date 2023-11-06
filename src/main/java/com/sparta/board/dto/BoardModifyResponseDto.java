package com.sparta.board.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardModifyResponseDto {
    private Long id;
    private String title;
    private String author;
    private String content;
    private LocalDateTime createDate;
}
