package com.yogiyo.clone.domain.user.entity;

import lombok.Getter;

@Getter
public enum UserRole {
    USER("ROLE_USER"), ADMIN("ROLE_ADMIN"), OWNER("ROLE_OWNER");

    private final String authority;

    UserRole(String authority) {
        this.authority = authority;
    }

}
