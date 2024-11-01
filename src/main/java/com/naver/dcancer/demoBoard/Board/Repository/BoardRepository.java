package com.naver.dcancer.demoBoard.Board.Repository;

import com.naver.dcancer.demoBoard.Board.Domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<Board> findByCode(String boardCode);
}
