package practic.controller;

import practic.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import practic.repository.UserRepository;

@RestController
@RequiredArgsConstructor
public class RegController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @PostMapping
    public void s(@RequestBody UserEntity userEntity) {
        String username = userEntity.getUserName();
        String password = userEntity.getPassword();
        String encode = passwordEncoder.encode(password);

        userRepository.save(userEntity);
    }

}