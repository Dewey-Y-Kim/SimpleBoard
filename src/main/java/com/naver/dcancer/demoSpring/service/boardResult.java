package com.naver.dcancer.demoSpring.service;

import com.naver.dcancer.demoSpring.domain.Board;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class boardResult {
     private final Long id;
     private final String title;
     private final String content;
     public static boardResult of(Board board) {
         return new boardResult(board.getId(), board.getTitle(),board.getContent());
     }
}
