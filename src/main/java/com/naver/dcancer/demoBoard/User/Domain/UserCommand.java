package com.naver.dcancer.demoBoard.User.Domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class UserCommand {

    @Getter
    @Setter
    public static class Create{
        private String name;
        private String nickName;
    }

    @Getter
    @Setter
    public static class Update{
        private String code;
        private String name;
        private String nickName;
    }
}
