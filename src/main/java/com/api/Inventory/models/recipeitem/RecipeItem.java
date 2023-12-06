package com.api.Inventory.models.recipeitem;

import com.api.Inventory.models.inventoryitem.InventoryItem;
import com.api.Inventory.models.recipe.Recipe;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class RecipeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("recipeId")
    private Long recipeId;

    @JsonProperty("itemId")
    private Long itemId;

    private float quantity;

    public RecipeItem() {
    }

    public RecipeItem(Long recipe, Long inventoryItem, float quantity) {
        this.recipeId = recipe;
        this.itemId = inventoryItem;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Long getRecipe() {
        return recipeId;
    }

    public void setRecipe(Long recipe) {
        this.recipeId = recipe;
    }

    public Long getInventoryItem() {
        return itemId;
    }

    public void setInventoryItem(Long inventoryItem) {
        this.itemId = inventoryItem;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
}
