package com.naver.dcancer.demoBoard.Hello.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping("/Hello")
    public String Hello(){
        return "Hello?";
    }

}
