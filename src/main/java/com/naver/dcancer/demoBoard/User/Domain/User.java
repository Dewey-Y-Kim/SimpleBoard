package com.naver.dcancer.demoBoard.User.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@RequiredArgsConstructor
@Table(name="users")
@Getter
@Setter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String nickName;

    public User(final UserCommand.Create create){
        this.code = UUID.randomUUID().toString();
        this.name = create.getName();
        this.nickName = create.getNickName();
    }
    public User(Long id ,final UserCommand.Update update){
        this.id = id;
        this.code = update.getCode();
        this.name = update.getName();
        this.nickName = update.getNickName();
    }
}
