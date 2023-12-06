package com.api.Inventory.models.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    private final SupplierRepository _db;

    @Autowired
    public SupplierService(SupplierRepository temp) {
        this._db = temp;
    }

    public List<Supplier> getAll() {
        return _db.findAll();
    }

    public void add(Supplier supplier) {
        _db.save(supplier);
    }
}
