package com.naver.dcancer.demoBoard.Article.Service;

import com.naver.dcancer.demoBoard.Article.Domain.Article;
import com.naver.dcancer.demoBoard.User.Domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleResult {
    private final Long id;
    private final String title;
    private final String content;
    private final String authorName;

    public static ArticleResult of(Article article){
        User author = article.getAuthor();
        return new ArticleResult(article.getId(), article.getTitle(), article.getContent(), author.getName());
    }
}
