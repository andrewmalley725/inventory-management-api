package com.api.Inventory.models.recipeitem;

import com.api.Inventory.models.inventoryitem.InventoryItem;
import com.api.Inventory.models.inventoryitem.InventoryItemRepository;
import com.api.Inventory.models.recipe.Recipe;
import com.api.Inventory.models.recipe.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeItemService {
    private final RecipeItemRepository _db;
    private final RecipeRepository rdb;
    private final InventoryItemRepository inv;

    public RecipeItemService(RecipeItemRepository repo, RecipeRepository recipe, InventoryItemRepository inv) {
        this._db = repo;
        this.rdb = recipe;
        this.inv = inv;
    }

    public List<RecipeItem> getAll() {
        return _db.findAll();
    }

    public Map<String, Object> add(RecipeItem newItem) {

        _db.save(newItem);

        Recipe recipe = rdb.findById(newItem.getRecipe())
                .orElseThrow(() -> new RuntimeException("Recipe not found with id: " + newItem.getRecipe()));

        InventoryItem inventory = inv.findById(newItem.getInventoryItem())
                .orElseThrow(() -> new RuntimeException("InventoryItem not found with id: " + newItem.getInventoryItem()));

        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("id", newItem.getId());
        payload.put("recipe", recipe);
        payload.put("item", inventory);

        return payload;
    }
}
