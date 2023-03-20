package by.home.authservice.service;

import by.home.authservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long getUserId(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password)
                       .orElseThrow(() -> new IllegalStateException("User not found"))
                       .getId();
    }
}
