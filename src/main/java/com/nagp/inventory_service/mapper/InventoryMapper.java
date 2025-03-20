package com.nagp.inventory_service.mapper;

import com.nagp.inventory_service.model.dto.InventoryDto;
import com.nagp.inventory_service.model.entity.Inventory;
import lombok.experimental.UtilityClass;

@UtilityClass
public class InventoryMapper {

    public InventoryDto toDto(Inventory inventory) {
        if (inventory == null) {
            return null;
        }
        InventoryDto dto = new InventoryDto();
        dto.setProductId(inventory.getProductId());
        dto.setSellerId(inventory.getSellerId());
        dto.setStockCount(inventory.getStockCount());
        dto.setLocation(inventory.getLocation());
        return dto;
    }

    public Inventory toEntity(InventoryDto dto) {
        if (dto == null) {
            return null;
        }
        Inventory inventory = new Inventory();
        inventory.setProductId(dto.getProductId());
        inventory.setSellerId(dto.getSellerId());
        inventory.setStockCount(dto.getStockCount());
        inventory.setLocation(dto.getLocation());
        return inventory;
    }
}
