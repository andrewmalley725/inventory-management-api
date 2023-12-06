package com.api.Inventory.models.inventoryitem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class InventoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private float cost;

    @JsonProperty("supplierId")
    private Long supplierId;

    public InventoryItem() {
    }

    public InventoryItem(String name, float cost, Long supplier) {
        this.name = name;
        this.cost = cost;
        this.supplierId = supplier;
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

    public Long getSupplier() {
        return supplierId;
    }

    public void setSupplier(Long supplier) {
        this.supplierId = supplier;
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
                ", supplier='" + supplierId + '\'' +
                '}';
    }
}
