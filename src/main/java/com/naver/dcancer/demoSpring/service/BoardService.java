package com.naver.dcancer.demoSpring.service;

import com.naver.dcancer.demoSpring.domain.Board;
import com.naver.dcancer.demoSpring.domain.BoardCommand;
import com.naver.dcancer.demoSpring.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public Page<boardResult> findAll(Pageable pageable) {
        return boardRepository.findAll(pageable).map(boardResult::of);
    }

    @Transactional(readOnly = true)
    public boardResult findById(Long id){
        return boardRepository.findById(id).map(boardResult::of).orElse(null);
    }

    @Transactional
    public boardResult create(BoardCommand.Create createCommand)
    {
        Board board = boardRepository.save(new Board(createCommand));
        return boardResult.of(board);
    }

    public void delete(Long id){
        boardRepository.findById(id).ifPresent(boardRepository::delete);
    }

    public boardResult update(Long id,BoardCommand.Update updateCommand){
        Board board = boardRepository.findById(id).orElseThrow(()-> {
            throw new IllegalArgumentException("There is no Id of the article");
        });
        if(board.getTitle().equals(updateCommand.getTitle())
                && board.getContent().equals( updateCommand.getContent())){
            System.out.println("no need to update");
            return null;
        }
        System.out.println("updated"+ id);
        updateCommand.setId(id);
        return boardResult.of(boardRepository.save(new Board(updateCommand)));

    }
}
