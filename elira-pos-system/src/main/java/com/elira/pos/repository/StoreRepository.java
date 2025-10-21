package com.elira.pos.repository;

import com.elira.pos.domain.StoreStatus;
import com.elira.pos.modal.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {

    Store findByStoreAdminId(Long adminId);

    List<Store> findByStatus(StoreStatus storeStatus);

    Long countByStatus(StoreStatus status);

    @Query("""
            SELECT count(s)
            from Store s
            where DATE(s.createdAt) = :date
            """)
    Long countByDate(LocalDate date);

    @Query("""
            SELECT DATE(s.createdAt) as regDate, COUNT(s) as count
            from Store s
            where s.createdAt >= :startDate
            GROUP BY DATE(s.createdAt)
            ORDER BY regDate DESC
            """)
    List<Object[]> getStoreRegistrationStats(
            @Param("startDate") LocalDateTime startDate
    );
}
