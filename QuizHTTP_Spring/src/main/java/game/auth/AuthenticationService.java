package game.auth;

import game.user.AppUser;
import game.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;

    void register(String userName, String password) {
        AppUser newUser = new AppUser(userName, password);

        if (userRepository.findByUserName(userName).isEmpty()) {
            throw new IllegalArgumentException("User already exists!");
        }

        userRepository.save(newUser);
    }

    boolean authenticate(String userName, String password) {
        var user = userRepository.findByUserName(userName).orElseThrow();

        return user.isPasswordCorrect(password);
    }
}
