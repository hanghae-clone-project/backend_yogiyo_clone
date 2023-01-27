package com.yogiyo.clone.domain.user.dto;

import com.yogiyo.clone.domain.user.entity.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfoDto {

    private Long id;
    private String username;
    private String email;

    public UserInfoDto(Users users) {
        this.id = users.getId();
        this.username = users.getUsername();
        this.email = users.getEmail();
    }

}
