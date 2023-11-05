package com.sparta.board.dto;

import lombok.Getter;

@Getter
public class BoardCreateRequestDto {
    private String title;
    private String author;
    private String password;
    private String content;
}
