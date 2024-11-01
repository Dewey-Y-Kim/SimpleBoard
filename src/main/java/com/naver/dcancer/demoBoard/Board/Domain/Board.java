package com.naver.dcancer.demoBoard.Board.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String code;

    private String name;

    public Board(BoardCommand.Create create){
        this.code = create.getCode();
        this.name = create.getName();
    }

}
