package com.yogiyo.clone.domain.store.repository;

import com.yogiyo.clone.domain.temporary_admin.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store,Long> {

}
