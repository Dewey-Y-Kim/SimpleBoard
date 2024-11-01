package com.naver.dcancer.demoBoard.Article.Service;

import com.naver.dcancer.demoBoard.Article.Domain.Article;
import com.naver.dcancer.demoBoard.Article.Domain.ArticleCommand;
import com.naver.dcancer.demoBoard.Article.Repository.ArticleRepository;
import com.naver.dcancer.demoBoard.Board.Domain.Board;
import com.naver.dcancer.demoBoard.Board.Service.BoardService;
import com.naver.dcancer.demoBoard.User.Domain.User;
import com.naver.dcancer.demoBoard.User.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final BoardService boardService;
    private final UserService userService;

    @Transactional(readOnly = true)
    public Page<ArticleResult> findAll(String boardCode, Pageable pageable) {
        Optional<Board> board = boardService.findByCode(boardCode);
        if (board.isEmpty()) {
            throw new RuntimeException("There is no Board");
        }
//        return articleRepository.findAll(pageable).map(ArticleResult::of);
        return articleRepository.findAllByBoardId(board.get().getId(), pageable).map(ArticleResult::of);
    }

    @Transactional(readOnly = true)
    public ArticleResult findById(String boardCord, Long id) {
        Optional<Board> board = boardService.findByCode(boardCord);
        if (board.isEmpty()) {
            throw new RuntimeException("There is no Board");
        }
//        return articleRepository.findById(id).map(ArticleResult::of).orElse(null);
        return articleRepository.findByBoardIdAndId(board.get().getId(), id).map(ArticleResult::of).orElse(null);
    }

    @Transactional
    public ArticleResult create(String boardCode, ArticleCommand.articleCreate create) {
        Optional<Board> board = boardService.findByCode(boardCode);

        final User user = userService.findByCode(create.getAuthorCode()).orElseThrow(() -> new RuntimeException("Sorry, But I can not identify You"));

        if (board.isEmpty()) {
            throw new RuntimeException("There is no Board");
        }
        Article article = articleRepository.save(new Article(board.get(), create, user));
        return ArticleResult.of(article);
    }

    @Transactional
    public ArticleResult update(String boardCode, Long id, ArticleCommand.articleUpdate update) {
        User user = userService.findByCode(update.getAuthorCode()).orElseThrow(() -> new RuntimeException("Sorry, But I can not Identify you."));

        Optional<Board> board = boardService.findByCode(boardCode);
        if (board.isEmpty()) {
            throw new RuntimeException("There is no Board");
        }

        Article article = articleRepository.save(new Article(board.get(), id, update, user));

        return ArticleResult.of(article);
    }

    @Transactional
    public void delete(Long id) {
        articleRepository.findById(id).ifPresent(articleRepository::delete);
    }

}
