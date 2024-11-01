package com.naver.dcancer.demoBoard.Board.Domain;

import lombok.Getter;
import lombok.Setter;


public class BoardCommand {
    private BoardCommand(){}
    @Getter
    @Setter
    public static class Create{
        private String name;
        private String code;
    }
    }
