package com.sparta.board;

import com.sparta.board.repository.BoardRepository;
import com.sparta.board.repository.JpaBoardRepository;
import com.sparta.board.service.BoardService;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final EntityManager em;
    private final DataSource dataSource;
    public SpringConfig(DataSource dateSource, EntityManager em){
        this.em = em;
        this.dataSource = dateSource;
    }

    @Bean
    public BoardService boardService() {
        return new BoardService(boardRepository());
    }

    @Bean
    public BoardRepository boardRepository(){
        return new JpaBoardRepository(em);
    }
}
