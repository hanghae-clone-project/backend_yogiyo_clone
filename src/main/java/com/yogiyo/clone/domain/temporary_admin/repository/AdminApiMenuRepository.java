package com.yogiyo.clone.domain.temporary_admin.repository;

import com.yogiyo.clone.domain.temporary_admin.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminApiMenuRepository extends JpaRepository<Menu, Long> {
}
