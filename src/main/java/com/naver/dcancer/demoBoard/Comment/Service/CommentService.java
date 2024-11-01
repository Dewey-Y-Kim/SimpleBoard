package com.naver.dcancer.demoBoard.Comment.Service;

import com.naver.dcancer.demoBoard.Article.Domain.Article;
import com.naver.dcancer.demoBoard.Article.Service.ArticleResult;
import com.naver.dcancer.demoBoard.Article.Service.ArticleService;
import com.naver.dcancer.demoBoard.Comment.Domain.Comment;
import com.naver.dcancer.demoBoard.Comment.Repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    ArticleService articleService;
    CommentRepository commentRepository
    //findArticle
    public List<Comment> getCommentsOfArticle(String boardCode,Long articleId){
        ArticleResult article = articleService.findById(boardCode, articleId);
        return null;
    }
    //add
asdgdasgdsagasd
    //updatef
    //delete
}
