package com.sparta.board.repository;

import com.sparta.board.domain.Board;

import java.util.List;
public interface BoardRepository {
    Board create(Board board);

    List<Board> findAll();

    Board findById(Long id);

    void deleteById(Long id);

    void modify(Board findBoard, Board inputBoard);

}
