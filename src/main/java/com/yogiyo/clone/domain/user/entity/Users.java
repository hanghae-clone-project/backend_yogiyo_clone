package com.yogiyo.clone.domain.user.entity;

import com.yogiyo.clone.domain.user.dto.SignUpForm;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static com.yogiyo.clone.domain.user.entity.UserRole.*;

@Getter
@Entity
@NoArgsConstructor
public class Users {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    private UserRole userRole;

    public Users(SignUpForm signUpForm) {
        this.username = signUpForm.getUsername();
        this.email = signUpForm.getEmail();
        this.password = signUpForm.getPassword();
        this.userRole = USER;
    }
}
