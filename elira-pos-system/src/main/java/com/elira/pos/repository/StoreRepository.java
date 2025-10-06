package com.elira.pos.repository;

import com.elira.pos.modal.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Store findByStoreAdminId(Long adminId);
}
