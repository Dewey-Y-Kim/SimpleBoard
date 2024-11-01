package com.naver.dcancer.demoBoard.Comment.Domain;

import com.naver.dcancer.demoBoard.Article.Domain.Article;
import com.naver.dcancer.demoBoard.User.Domain.User;
import jakarta.persistence.*;

@Entity
@Table
public class Comment {
    @Id
    private Long id;

    @Column(nullable = false)
    private String comment;

    @ManyToOne
    private User author;

    @ManyToOne
    private Article article;

    public Comment(CommentCommand.Create create, Article article, User author){
        this.comment = create.getComment();
        this.author = author;
        this.article = article;
    }
    //확인은 조금있다가...

    public Comment(CommentCommand.Update update, Article article, User author){
        this.comment = update.getComment();
        this.author = author;
        this.article = article;
        this.id = id;
    }
}
