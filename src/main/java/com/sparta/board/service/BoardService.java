package com.sparta.board.service;

import com.sparta.board.domain.Board;
import com.sparta.board.dto.BoardCreateRequestDto;
import com.sparta.board.dto.BoardDeleteRequestDto;
import com.sparta.board.dto.BoardModifyRequestDto;
import com.sparta.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService (BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    // 게시글 작성
    public Board createBoard(BoardCreateRequestDto boardCreateRequestDto){
        Board board = new Board(boardCreateRequestDto.getTitle(),
                boardCreateRequestDto.getAuthor(),
                boardCreateRequestDto.getPassword(),
                boardCreateRequestDto.getContent(),
                LocalDateTime.now());
        return boardRepository.create(board);
    }

    // 선택한 게시글 조회
    public Board findBoard(Long id){
        Board board =  boardRepository.findById(id);
        return board;
    }

    // 전체 게시글 조회
    public List<Board> findAllBoard(){
        return boardRepository.findAll();
    }

    // 게시글 수정
    @Transactional
    public void modifyBoard(Long id,BoardModifyRequestDto boardModifyRequestDto){
        Board board = boardRepository.findById(id);
        if(board.getPassword()
                .equals(boardModifyRequestDto.getPassword())){
            board.setTitle(boardModifyRequestDto.getTitle());
            board.setAuthor(boardModifyRequestDto.getAuthor());
            board.setContent(boardModifyRequestDto.getContent());
        } else{
            System.out.println("비밀번호가 일치하지 않거나 존재하지 않는 게시물입니다.");
        }
    }
    // 게시글 삭제
    public void removeBoard(BoardDeleteRequestDto boardDeleteRequestDto){
        Board findBoard = boardRepository.findById(boardDeleteRequestDto.getId());
        if(findBoard.getPassword().equals(boardDeleteRequestDto.getPassword())){
            boardRepository.deleteById(boardDeleteRequestDto.getId());
        } else {
            System.out.println("비밀번호가 일치하지 않습니다.");
        }
    }
}
