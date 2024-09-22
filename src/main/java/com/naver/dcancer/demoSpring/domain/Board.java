package com.naver.dcancer.demoSpring.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    private Long viewCount;
    public Board(BoardCommand.Create create) {
        this.title =create.getTitle();
        this.content = create.getContent();
    }

    public Board(BoardCommand.Update update) {
        this.id = update.getId();
        this.title = update.getTitle();
        this.content = update.getContent();
    }
}
