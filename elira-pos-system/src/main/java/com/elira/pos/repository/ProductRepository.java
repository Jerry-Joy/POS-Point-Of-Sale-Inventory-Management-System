package com.elira.pos.repository;

import com.elira.pos.modal.Product;
import com.elira.pos.payload.branchAnalytics.CategorySalesDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByStoreId(Long storeId);

    @Query(
            "SELECT p FROM Product p "+
                    "WHERE p.store.id = :storeId AND (" +
                    "LOWER( p.name) LIKE LOWER(CONCAT('%', :query, '%'))"+
                    "Or LOWER( p.brand) LIKE LOWER(CONCAT('%', :query, '%'))"+
                    "Or LOWER( p.sku) LIKE LOWER(CONCAT('%', :query, '%'))"+
                    ")"
    )
    List<Product> searchByKeyword(@Param("storeId")Long storeId,
                                  @Param("query")String keyword);


    @Query("""
            select count (p) from Product p
            where p.store.storeAdmin.id = :storeAdminId
            """)
    int countByStoreAdminId(@Param("storeAdminId")Long storeAdminId);


    @Query("""
            select p.name from Product p
            where p.store.storeAdmin.id = :storeAdminId
            and p.id Not in (
                select i.product.id from Inventory i
                where i.quantity > 5
            )
            """)
    List<String> findLowStockProducts(
            @Param("storeAdminId") Long storeAdminId);


//    List<CategorySalesDTO> getSalesGroupedByCategory(
//            @Param("storeAdminId")Long storeAdminId);
}
