package com.sparta.board.service;

import com.sparta.board.domain.Board;
import com.sparta.board.dto.BoardCreateRequestDto;
import com.sparta.board.dto.BoardFindResponseDto;
import com.sparta.board.repository.BoardRepository;
import com.sparta.board.repository.JpaBoardRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional
public class BoardService {
    private final BoardRepository boradRepository;

    public BoardService (BoardRepository boardRepository){
        this.boradRepository = boardRepository;
    }

    // 게시글 작성
    public Board createBoard(BoardCreateRequestDto boardCreateRequestDto){
        Board board = new Board(boardCreateRequestDto.getTitle(),
                boardCreateRequestDto.getAuthor(),
                boardCreateRequestDto.getPassword(),
                boardCreateRequestDto.getContent(),
                LocalDateTime.now());
        return boradRepository.create(board);
    }

    // 선택한 게시글 조회
    public Board findBoard(Long id){
        Board board =  boradRepository.findById(id);
        return board;
    }

    // 전체 게시글 조회
    public List<Board> findAllBoard(){
        return boradRepository.findAll();
    }
    // 게시글 수정

    // 게시글 삭제
    public void removeBoard(Long id, String password){
        Board findBoard = boradRepository.findById(id);
        if(findBoard.getPassword().equals(password)){
            boradRepository.deleteById(id);
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");
        }
    }
}
