package com.elira.pos.repository;

import com.elira.pos.domain.UserRole;
import com.elira.pos.modal.Store;
import com.elira.pos.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    List<User> findByStore(Store store);
    List<User> findByBranchId(Long branchId);


    @Query("""
            select count(u)
            from User u
            where u.id in(
                select s.storeAdmin.id from Store s
                where s.storeAdmin.id = :storeAdminId)
                AND u.role IN :roles
            """)
    int countByStoreAdminIdAndRoles(
            @Param("storeAdminId") Long storeAdminId,
            @Param("roles") List<UserRole> roles
    );


    @Query("""
            select u.fullName
            from User u
            where u.lastLogin < :cutoffDate
            AND u.id in(
                select u2.storeAdmin.id from Store u2
                WHERE u2.storeAdmin.id = :storeAdminId)
                AND u.role = com.elira.pos.domain.UserRole.ROLE_CASHIER
            """)
    List<String> findInActiveCashiers(@Param("storeAdminId") Long StoreAdminId,
                                      @Param("cutoffDate") LocalDateTime cutoffDate);
}
