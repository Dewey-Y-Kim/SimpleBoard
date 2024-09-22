package com.naver.dcancer.demoSpring.controller;


import com.naver.dcancer.demoSpring.domain.BoardCommand;
import com.naver.dcancer.demoSpring.service.BoardService;
import com.naver.dcancer.demoSpring.service.boardResult;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class boardController {
    private final BoardService boardService;

    @GetMapping
    public Page<boardResult> findAllboard(Pageable pageable) {
        return boardService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public boardResult findBoardById(@PathVariable Long id) {
        return boardService.findById(id);
    }

    @PostMapping
    public boardResult addBoard(@RequestBody BoardCommand.Create createCommand) {
        return boardService.create(createCommand);
    }

    @DeleteMapping("/{id}")
    public void deleteBoardById(@PathVariable Long id) {
        boardService.delete(id);
    }

    @PatchMapping("/{id}")
    public boardResult updateBoardById(@PathVariable Long id, @RequestBody BoardCommand.Update updateCommand) {
        // boardService

        return boardService.update(id, updateCommand);
    }
}
