package com.yogiyo.clone.domain.temporary_admin.repository;

import com.yogiyo.clone.domain.temporary_admin.entity.Store;
import com.yogiyo.clone.domain.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminApiRepository extends JpaRepository<Store, Long> {

    List<Store> findByUsers(Users users);

}
