package com.api.Inventory.controllers;

import com.api.Inventory.models.inventoryitem.InventoryItem;
import com.api.Inventory.models.inventoryitem.InventoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class InventoryItemController {
    private final InventoryItemService _db;

    @Autowired
    public InventoryItemController(InventoryItemService db) {
        this._db = db;
    }

    @GetMapping("/inventory-items")
    public List<Map<String, Object>> Base() {
        return _db.getAll();
    }

    @PostMapping("/add-item")
    public InventoryItem NewItem(@RequestBody InventoryItem item) {
        _db.add(item);
        return item;
    }
}
