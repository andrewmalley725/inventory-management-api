package com.api.Inventory.models.inventoryitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryItemService {
    private final InventoryItemRepository _db;

    @Autowired
    public InventoryItemService(InventoryItemRepository db) {
        this._db = db;
    }

    public List<InventoryItem> getAll()
    {
        List<InventoryItem> list =  _db.findAll();

        return list;
    }

    public void add(InventoryItem item) {
        _db.save(item);
    }
}
