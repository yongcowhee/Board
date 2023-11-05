package com.sparta.board.repository;

import com.sparta.board.domain.Board;
import jakarta.persistence.EntityManager;

import java.util.List;

public class JpaBoardRepository implements BoardRepository {

    private final EntityManager em;
    public JpaBoardRepository(EntityManager em){
        this.em = em;
    }
    @Override
    public Board create(Board board) {
        em.persist(board); // 영속성 컨텍스트에 저장
        return board;
    }

    @Override
    public List<Board> findAll() {
        return em.createQuery("select b from Board b", Board.class).getResultList();
    }

    @Override
    public Board findById(Long id) {
        return em.find(Board.class, id);
    }

    @Override
    public void deleteById(Long id) {
        em.remove(findById(id));
    }

    @Override
    public void modify(Board findBoard, Board inputBoard) {
        findBoard.setTitle(inputBoard.getTitle());
        findBoard.setContent(inputBoard.getContent());
        findBoard.setAuthor(inputBoard.getAuthor());
        findBoard.setPassword(inputBoard.getPassword());
    }
}