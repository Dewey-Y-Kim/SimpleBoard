package com.naver.dcancer.demoBoard.Comment.Repository;

import com.naver.dcancer.demoBoard.Comment.Domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
