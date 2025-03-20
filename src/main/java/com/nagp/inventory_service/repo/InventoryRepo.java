package com.nagp.inventory_service.repo;

import com.nagp.inventory_service.model.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InventoryRepo extends JpaRepository<Inventory,String> {
    @Query("SELECT i.stockCount FROM Inventory i WHERE i.productId = :productId")
    Integer findStockCountByProductId(@Param("productId") String productId);
}
