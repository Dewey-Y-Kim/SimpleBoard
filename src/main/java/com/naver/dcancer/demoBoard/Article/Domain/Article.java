package com.naver.dcancer.demoBoard.Article.Domain;

import com.naver.dcancer.demoBoard.Board.Domain.Board;
import com.naver.dcancer.demoBoard.User.Domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter

@RequiredArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    private User author;

    public Article(Board board, ArticleCommand.articleCreate command, User author){
        this.board = board;
        this.author = author;
        this.title = command.getTitle();
        this.content = command.getContent();

    }

    public Article(Board board, Long id, ArticleCommand.articleUpdate update, User author) {
        this.board = board;
        this.author = author;
        this.id = id;
        this.title = update.getTitle();
        this.content = update.getContent();

    }

//    public Article(Board board, ArticleCommand.articleCreate create) {
//        this.board = board;
//        this.title =
//    }
}
