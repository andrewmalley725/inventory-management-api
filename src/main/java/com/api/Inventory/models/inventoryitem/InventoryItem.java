package com.api.Inventory.models.inventoryitem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class InventoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private float cost;

    private String supplier;

    public InventoryItem() {
    }

    public InventoryItem(String name, float cost, String supplier) {
        this.name = name;
        this.cost = cost;
        this.supplier = supplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Long getId() {
        return id;
    }

    @Override
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public String toString() {
        return "InventoryItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", supplier='" + supplier + '\'' +
                '}';
    }
}
