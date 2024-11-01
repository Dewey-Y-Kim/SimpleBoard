package com.naver.dcancer.demoBoard.User.Service;

import com.naver.dcancer.demoBoard.User.Domain.User;
import com.naver.dcancer.demoBoard.User.Domain.UserCommand;
import com.naver.dcancer.demoBoard.User.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findByCode(String userCode){
        return userRepository.findByCode(userCode);
    }

    @Transactional
    public UserResult create(UserCommand.Create create){
        User user = userRepository.save(new User(create));
        return UserResult.of(user);
    }

    @Transactional
    public UserResult update(Long id, UserCommand.Update update){
        User user = userRepository.save(new User(id, update));
        return UserResult.of(user);
    }

    @Transactional
    public void delete(String userCode){
        userRepository.findByCode(userCode).ifPresent(userRepository::delete);
    }
}
