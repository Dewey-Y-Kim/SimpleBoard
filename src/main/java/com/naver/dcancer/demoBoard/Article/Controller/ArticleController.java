package com.naver.dcancer.demoBoard.Article.Controller;

import com.naver.dcancer.demoBoard.Article.Domain.ArticleCommand;
import com.naver.dcancer.demoBoard.Article.Service.ArticleResult;
import com.naver.dcancer.demoBoard.Article.Service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{boardCode}/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping
    public Page<ArticleResult> findAllBoards(@PathVariable String boardCode,Pageable pageable){
        return articleService.findAll(boardCode, pageable);
    }

    @GetMapping("/{id}")
    public ArticleResult findArticleById(@PathVariable String boardCode, @PathVariable Long id ){
        return articleService.findById(boardCode, id);
    }

    @PostMapping
    public ArticleResult addArticle(@PathVariable String boardCode, @RequestBody ArticleCommand.articleCreate create){
        return articleService.create(boardCode, create);
    }

    @PatchMapping("/{id}")
    public  ArticleResult updateArticle(@PathVariable String boardCode, @PathVariable Long id, @RequestBody ArticleCommand.articleUpdate update){
        return articleService.update(boardCode, id, update);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(Long id){
        articleService.delete(id);
    }
}
