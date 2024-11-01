package com.naver.dcancer.demoBoard.Board.Controller;

import com.naver.dcancer.demoBoard.Board.Domain.BoardCommand;
import com.naver.dcancer.demoBoard.Board.Service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void add(@RequestBody BoardCommand.Create create){
        boardService.create(create);
    }
}
