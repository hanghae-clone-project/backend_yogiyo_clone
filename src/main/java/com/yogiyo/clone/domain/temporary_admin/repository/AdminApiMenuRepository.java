package com.yogiyo.clone.domain.temporary_admin.repository;

import com.yogiyo.clone.domain.temporary_admin.entity.Menu;
import com.yogiyo.clone.domain.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminApiMenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findByUserid(Long user_id);
}
