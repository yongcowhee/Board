package com.sparta.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class BoardCreateResponseDto {
    private Long id;
    private String title;
    private String author;
    private String content;
    private LocalDateTime createDate;


}