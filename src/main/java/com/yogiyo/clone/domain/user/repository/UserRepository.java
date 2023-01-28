package com.yogiyo.clone.domain.user.repository;

import com.yogiyo.clone.domain.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUsername(String username);
    Optional<Users> findByEmail(String email);

    @Query(value = "select u.email as email from Users as u where u.email = ?1")
    String findEmailByEmail(String email);

    @Query(value = "select u.username as username from Users as u where u.username = ?1")
    String findUsernameByUsername(String username);

}
