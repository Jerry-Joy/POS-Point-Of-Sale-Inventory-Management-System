package com.elira.pos.repository;

import com.elira.pos.modal.Refund;
import com.elira.pos.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface RefundRepository extends JpaRepository<Refund, Long> {

    List<Refund> findByCashierIdAndCreatedAtBetween(
            Long cashier,
            LocalDateTime rom,
            LocalDateTime to
    );

    List<Refund> findByCashierId(Long id);
    List<Refund> findByShiftReportId(Long id);
    List<Refund> findByBranchId(Long id);


    @Query("""
            select count(r)
            from Refund r
            where r.order.branch.store.id = :storeAdminId
            """)
    int countByStoreAdminId(@Param("storeAdminId") Long storeAdminId);


    @Query("""
            select r.reason, count(r)
            from Refund r
            where r.order.branch.store.id = :storeAdminId
            GROUP BY function('DATE', r.createdAt)
            having sum(r.amount) > 5
            """)
    List<String> findRefundSpikes(@Param("storeAdminId") Long storeAdminId);
}
