package com.yogiyo.clone.domain.temporary_admin.repository;

import com.yogiyo.clone.domain.temporary_admin.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminApiRepository extends JpaRepository<Store, Long> {

}
