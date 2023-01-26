package com.yogiyo.clone.domain.user.service;

import com.yogiyo.clone.domain.user.dto.LoginForm;
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
        String encryptPassword = passwordEncoder.encode(form.getPassword());
        SignUpForm encryptSignUpForm = new SignUpForm(form, encryptPassword);

        userRepository.save(new Users(encryptSignUpForm));
    }


    public void checkedEmailDuplication(SignUpForm form) {
        Optional<Users> email = userRepository.findByEmail(form.getEmail());
        if (email.isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }
    }
    public void checkedUsernameDuplication(SignUpForm form) {
        Optional<Users> username = userRepository.findByUsername(form.getUsername());
        if (username.isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 닉네임입니다.");
        }
    }

    public Users login(LoginForm form) {
        Users users = userRepository.findByEmail(form.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 아이디"));

        if (!passwordEncoder.matches(form.getPassword(), users.getPassword())) {
            throw new IllegalArgumentException("올바르지 않은 비밀번호");
        }

        return users;
    }
}
