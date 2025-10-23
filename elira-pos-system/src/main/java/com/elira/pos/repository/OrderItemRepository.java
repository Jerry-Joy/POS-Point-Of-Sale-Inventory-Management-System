package com.elira.pos.repository;

import com.elira.pos.modal.OrderItem;
import com.elira.pos.payload.branchAnalytics.CategorySalesDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    @Query("""
            select p.id, p.name, sum(oi.quantity) as totalProduct from OrderItem oi
            join oi.product p
            join oi.order o
            where o.branch.id = :branchId
            GROUP BY p.id, p.name
            order by totalProduct desc
            """)
    List<Object[]> getTopProductsByQuantity(
            @Param("branchId") Long branchId
    );

    @Query("""
            select c.name, sum(oi.quantity * oi.price) as totalAmount from OrderItem oi
            join oi.product p
            join oi.order o
            join p.category c
            where o.branch.id = :branchId
            And o.createdAt BETWEEN :start and :end
            GROUP BY p.id, c.name
            order by totalAmount desc
            """)
    List<Object[]> getCategoryWiseSales(
            @Param("branchId") Long branchId,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );

  /* @Query("""
            select new com.elira.pos.payload.branchAnalytics.CategorySalesDTO(
            p.category.name,
            sum(oi.quantity * p.sellingPrice),
            Long(1)
            )
            FROM OrderItem oi
            Join oi.product p
            where p.store.storeAdmin.id = :storeAdminId
            GROUP BY p.category.name
            """)
    List<CategorySalesDTO> getSalesGroupedByCategory(
            @Param("storeAdminId") Long storeAdminId
    );*/

}
