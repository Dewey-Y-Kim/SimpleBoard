package com.naver.dcancer.demoBoard.Article.Domain;

import lombok.Getter;
import lombok.Setter;

public final class ArticleCommand {
    private ArticleCommand(){

    }
    @Setter
    @Getter
    public static class articleCreate{
        private String title;
        private String content;
        private String authorCode;
    }

    @Setter
    @Getter
    public  static class articleUpdate{
        private Long id;
        private String title;
        private String content;
        private String authorCode;

    }
}
