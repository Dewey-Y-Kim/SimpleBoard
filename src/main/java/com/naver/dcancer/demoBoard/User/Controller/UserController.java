package com.naver.dcancer.demoBoard.User.Controller;

import com.naver.dcancer.demoBoard.User.Domain.UserCommand;
import com.naver.dcancer.demoBoard.User.Service.UserResult;
import com.naver.dcancer.demoBoard.User.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/User")
public class UserController {
    private UserService userService;

    @PostMapping
    public UserResult add(@RequestBody UserCommand.Create create){
        return userService.create(create);
    }

    @PatchMapping("/{id}")
    public UserResult modify(@RequestBody UserCommand.Update update, @PathVariable Long id){
        return userService.update(id, update);
    }

}
