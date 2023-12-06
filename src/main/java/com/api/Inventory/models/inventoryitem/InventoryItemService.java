package com.api.Inventory.models.inventoryitem;

import com.api.Inventory.models.supplier.Supplier;
import com.api.Inventory.models.supplier.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InventoryItemService {
    private final InventoryItemRepository _db;
    private final SupplierRepository sup;

    @Autowired
    public InventoryItemService(InventoryItemRepository db, SupplierRepository sup) {
        this._db = db;
        this.sup = sup;
    }

    public List<InventoryItem> tots() {
        return _db.findAll();
    }

    public List<Map<String, Object>> getAll()
    {
        List<InventoryItem> list =  _db.findAll();
        List<Map<String, Object>> payload = new ArrayList<>();

        for (InventoryItem i : list) {
            Supplier supplier = sup.findById(i.getSupplier())
                    .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + i.getSupplier()));
            Map<String, Object> item = new HashMap<>();
            item.put("id", i.getId());
            item.put("name", i.getName());
            item.put("cost", i.getCost());
            item.put("supplier", supplier);
            payload.add(item);
        }

        return payload;
    }

    public void add(InventoryItem item) {
        _db.save(item);
    }
}
