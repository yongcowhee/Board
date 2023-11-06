package com.sparta.board.dto;

import lombok.Getter;

@Getter
public class BoardModifyRequestDto {
    private String title;
    private String author;
    private String content;
    private String password;
}
