package com.nagp.inventory_service.service;

import com.nagp.inventory_service.model.dto.InventoryDto;
import com.nagp.inventory_service.model.entity.Inventory;

public interface InventoryService {

    int getStockLevel(String productId);

    InventoryDto addUpdate(InventoryDto inventoryDto);

    InventoryDto updateInventory(InventoryDto inventoryDto);

}
