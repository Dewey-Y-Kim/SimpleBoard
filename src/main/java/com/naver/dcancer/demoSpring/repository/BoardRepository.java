package com.naver.dcancer.demoSpring.repository;

import com.naver.dcancer.demoSpring.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
