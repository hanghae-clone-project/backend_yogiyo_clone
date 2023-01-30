package com.yogiyo.clone.domain.user.service;

import com.yogiyo.clone.domain.user.dto.LoginForm;
import com.yogiyo.clone.domain.user.dto.SignUpForm;
import com.yogiyo.clone.domain.user.dto.UserInfoDto;
import com.yogiyo.clone.domain.user.entity.UserRole;
import com.yogiyo.clone.domain.user.entity.Users;
import com.yogiyo.clone.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.yogiyo.clone.exception.message.ExceptionMessage.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public void signUp(SignUpForm form) {
        String encryptPassword = passwordEncoder.encode(form.getPassword());
        SignUpForm encryptSignUpForm = new SignUpForm(form, encryptPassword);

        if (!form.getUserRole().equals(""))
            userRepository.save(new Users(encryptSignUpForm, UserRole.OWNER));
        else
            userRepository.save(new Users(encryptSignUpForm));
    }

    public void checkedEmailDuplication(String email) {
        String findEmail = userRepository.findEmailByEmail(email);

        if (isExisted(findEmail)) {
            throw new IllegalArgumentException(EXISTED_EMAIL.getDescription());
        }
    }
    public void checkedUsernameDuplication(String username) {
        String findUsername = userRepository.findUsernameByUsername(username);

        if (isExisted(findUsername)) {
            throw new IllegalArgumentException(EXISTED_USERNAME.getDescription());
        }
    }

    public Users login(LoginForm form) {
        Users users = userRepository.findByEmail(form.getEmail())
                .orElseThrow(() -> new BadCredentialsException(INCORRECT_SIGN_IN_TRY.getDescription()));

        if (!passwordEncoder.matches(form.getPassword(), users.getPassword())) {
            throw new BadCredentialsException(INCORRECT_SIGN_IN_TRY.getDescription());
        }

        return users;
    }

    private boolean isExisted(String field) {
        return field != null;
    }

    public List<UserInfoDto> getUserList() {
        List<Users> users = userRepository.findAll();
        List<UserInfoDto> userList = new ArrayList<>();

        for (Users user : users) {
            if (!user.getUserRole().equals(UserRole.USER))
                userList.add(new UserInfoDto(user));
        }

        return userList;
    }
}
