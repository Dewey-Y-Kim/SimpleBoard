package com.naver.dcancer.demoBoard.Board.Service;

import com.naver.dcancer.demoBoard.Board.Domain.Board;
import com.naver.dcancer.demoBoard.Board.Domain.BoardCommand;
import com.naver.dcancer.demoBoard.Board.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void create(BoardCommand.Create create){
        boardRepository.save(new Board(create));
    }

    public Optional<Board> findByCode(String boardCode){
        return boardRepository.findByCode(boardCode);
    }
}
