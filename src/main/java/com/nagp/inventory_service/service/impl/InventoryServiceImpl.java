package com.nagp.inventory_service.service.impl;

import com.nagp.inventory_service.mapper.InventoryMapper;
import com.nagp.inventory_service.model.dto.InventoryDto;
import com.nagp.inventory_service.model.entity.Inventory;
import com.nagp.inventory_service.repo.InventoryRepo;
import com.nagp.inventory_service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepo inventoryRepo;

    @Override
    public int getStockLevel(String productId) {
        Integer stockCountByProductId = inventoryRepo.findStockCountByProductId(productId);
        if(Objects.nonNull(stockCountByProductId)){
            return stockCountByProductId;
        }else{
            return 0;
        }
    }

    @Override
    public InventoryDto addUpdate(InventoryDto inventoryDto) {
        Inventory inventory = InventoryMapper.toEntity(inventoryDto);
        Inventory saved = inventoryRepo.save(inventory);
        return InventoryMapper.toDto(saved);
    }

    @Override
    public InventoryDto updateInventory(InventoryDto inventoryDto) {
        Optional<Inventory> inventoryOptional = inventoryRepo.findById(inventoryDto.getProductId());
        if(inventoryOptional.isPresent()){
            Inventory inventory = inventoryOptional.get();
            Integer updateStocked = inventory.getStockCount()- inventoryDto.getStockCount();
            inventory.setStockCount(updateStocked);
            Inventory saved = inventoryRepo.save(inventory);
            return InventoryMapper.toDto(saved);
        }
        return null;
    }
}
