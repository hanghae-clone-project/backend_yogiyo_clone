package com.yogiyo.clone.domain.user.service;

import com.yogiyo.clone.domain.user.dto.SignUpForm;
import com.yogiyo.clone.domain.user.entity.Users;
import com.yogiyo.clone.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public void signUp(SignUpForm form) {
        Optional<Users> optionalUser = userRepository.findByUsername(form.getUsername());

        if (optionalUser.isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 유저");
        }
        String encryptPassword = passwordEncoder.encode(form.getPassword());
        SignUpForm encryptSignUpForm = new SignUpForm(form, encryptPassword);

        userRepository.save(new Users(encryptSignUpForm));
    }
}
