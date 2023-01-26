package com.yogiyo.clone.domain.user.service;

import com.yogiyo.clone.domain.user.dto.LoginForm;
import com.yogiyo.clone.domain.user.dto.SignUpForm;
import com.yogiyo.clone.domain.user.entity.Users;
import com.yogiyo.clone.domain.user.repository.UserRepository;
import com.yogiyo.clone.exception.message.ExceptionMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

import static com.yogiyo.clone.exception.message.ExceptionMessage.*;

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
            throw new IllegalArgumentException(EXISTED_EMAIL.getDescription());
        }
    }
    public void checkedUsernameDuplication(SignUpForm form) {
        Optional<Users> username = userRepository.findByUsername(form.getUsername());
        if (username.isPresent()) {
            throw new IllegalArgumentException(EXISTED_USERNAME.getDescription());
        }
    }

    public Users login(LoginForm form) {
        Users users = userRepository.findByEmail(form.getEmail())
                .orElseThrow(() -> new IllegalArgumentException(INCORRECT_SIGN_IN_TRY.getDescription()));

        if (!passwordEncoder.matches(form.getPassword(), users.getPassword())) {
            throw new IllegalArgumentException(INCORRECT_SIGN_IN_TRY.getDescription());
        }

        return users;
    }
}
