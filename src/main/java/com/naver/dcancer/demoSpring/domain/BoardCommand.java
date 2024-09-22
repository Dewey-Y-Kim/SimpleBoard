package com.naver.dcancer.demoSpring.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class BoardCommand {
    private BoardCommand(){

    }
    @Getter
    @Setter
    public static class Create{
        private String title;
        private String content;
    }

    @Getter
    @Setter
    @ToString
    public static class Update{
        private Long id;
        private String title;
        private String content;
    }
}
