package com.api.Inventory.controllers;

import com.api.Inventory.models.supplier.Supplier;
import com.api.Inventory.models.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SupplierController {
    private final SupplierService _db;

    @Autowired
    public SupplierController(SupplierService temp) {
        this._db = temp;
    }

    @GetMapping("/suppliers")
    public List<Supplier> Base() {
        return _db.getAll();
    }

    @PostMapping("/new-supplier")
    public Supplier addNew(@RequestBody Supplier supplier) {
        _db.add(supplier);
        return supplier;
    }
}
