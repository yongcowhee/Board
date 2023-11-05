package com.sparta.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardFindResponseDto {
    private Long id;
    private String title;
    private String author;
    private String content;
    private LocalDateTime createDate;
}
