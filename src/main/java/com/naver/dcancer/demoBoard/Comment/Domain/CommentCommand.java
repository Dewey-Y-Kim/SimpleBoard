package com.naver.dcancer.demoBoard.Comment.Domain;

import lombok.Getter;
import lombok.Setter;

public class CommentCommand {
    @Getter
    @Setter
    public static class Create{
//        private String userCode;
        private String comment;

    }

    @Setter
    @Getter
    public static class Update{
        private Long id;
        private String comment;
    }
}
