package com.sparta.board.controller;
import com.sparta.board.domain.Board;
import com.sparta.board.dto.*;
import com.sparta.board.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BoardController {
    private final BoardService boardService;
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @PostMapping("/board")
    public BoardCreateResponseDto create(@RequestBody BoardCreateRequestDto boardCreateRequestDto){
        Board board = boardService.createBoard(boardCreateRequestDto);
        BoardCreateResponseDto boardCreateResponseDto = new BoardCreateResponseDto(
                board.getId(),
                board.getTitle(),
                board.getAuthor(),
                board.getContent(),
                board.getCreateDate()
                );
        return boardCreateResponseDto;
    }

    @GetMapping("/board/{id}")
    public BoardFindResponseDto findById(@PathVariable Long id){
            Board board = boardService.findBoard(id);
        return new BoardFindResponseDto(
                board.getId(),
                board.getTitle(),
                board.getAuthor(),
                board.getContent(),
                board.getCreateDate()
        );
    }

    @GetMapping("/allBoard")
    public List<BoardFindResponseDto> findAllBoard(){
        List<Board> findBoardList = boardService.findAllBoard();
        List<BoardFindResponseDto> boardFindResponseDtoList = new ArrayList<>();
        for (Board b : findBoardList) {
            BoardFindResponseDto boardFindResponseDto = new BoardFindResponseDto();
            boardFindResponseDto.setId(b.getId());
            boardFindResponseDto.setTitle(b.getTitle());
            boardFindResponseDto.setAuthor(b.getAuthor());
            boardFindResponseDto.setContent(b.getContent());
            boardFindResponseDto.setCreateDate(b.getCreateDate());
            boardFindResponseDtoList.add(boardFindResponseDto);
        }
        return boardFindResponseDtoList;
    }

    @DeleteMapping("/board")
    public void removeBoard(@RequestBody BoardDeleteRequestDto boardDeleteRequestDto){
        boardService.removeBoard(boardDeleteRequestDto);
    }

    @PatchMapping("/board/{id}")
    public void modifyBoard(@PathVariable Long id,
                            @RequestBody BoardModifyRequestDto boardModifyRequestDto){
        boardService.modifyBoard(id, boardModifyRequestDto);
    }
}