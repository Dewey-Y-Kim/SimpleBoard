package com.naver.dcancer.demoBoard.User.Service;

import com.naver.dcancer.demoBoard.User.Domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class UserResult {
    private final String code;
    private final String nickName;

    public static UserResult of(User user){
        return new UserResult(user.getCode(), user.getNickName());
    }
}
