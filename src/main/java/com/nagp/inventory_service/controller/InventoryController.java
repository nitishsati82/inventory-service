package com.nagp.inventory_service.controller;

import com.nagp.inventory_service.model.dto.InventoryDto;
import com.nagp.inventory_service.model.entity.Inventory;
import com.nagp.inventory_service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/check/{productId}")
    public ResponseEntity<Integer> checkStock(@PathVariable String productId) {
        int quantity = inventoryService.getStockLevel(productId);
        return ResponseEntity.ok(quantity);
    }

    @PostMapping("/update")
    public ResponseEntity<InventoryDto> addUpdate(@RequestBody InventoryDto inventoryDto) {
        return ResponseEntity.ok(inventoryService.addUpdate(inventoryDto));
    }

    @PostMapping("/order-inventory-update")
    public ResponseEntity<InventoryDto> update(@RequestBody InventoryDto inventoryDto) {
        return ResponseEntity.ok(inventoryService.updateInventory(inventoryDto));
    }
}
