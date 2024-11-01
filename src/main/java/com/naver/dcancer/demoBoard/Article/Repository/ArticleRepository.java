package com.naver.dcancer.demoBoard.Article.Repository;

import com.naver.dcancer.demoBoard.Article.Domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Page<Article> findAllByBoardId(Long boardId, Pageable pageable);

    Optional<Article> findByBoardIdAndId(Long boardId, Long id);
}
