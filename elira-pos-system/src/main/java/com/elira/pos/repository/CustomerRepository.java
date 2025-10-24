package com.elira.pos.repository;

import com.elira.pos.modal.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByFullNameContainingIgnoreCaseOrEmailContainingIgnoreCase (
            String fullName, String email);


    @Query("""
            select count (distinct o.customer.id) from Order o
            where o.branch.store.storeAdmin.id = :storeAdminId
            """)
    int countByStoreAdminId(@Param("storeAdminId")Long storeAdminId);
}
