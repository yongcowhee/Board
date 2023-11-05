package com.sparta.board.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성 데이터베이스에 위임
    private Long id;
    private String title;
    private String author;
    private String password;
    private String content;
    private LocalDateTime createDate;

    public Board(String title, String author, String password, String content, LocalDateTime createTime) {
        this.title = title;
        this.author = author;
        this.password = password;
        this.content = content;
        this.createDate = createTime;
    }
}
