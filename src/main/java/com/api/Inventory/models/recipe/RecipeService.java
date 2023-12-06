package com.api.Inventory.models.recipe;

import com.api.Inventory.models.inventoryitem.InventoryItem;
import com.api.Inventory.models.inventoryitem.InventoryItemRepository;
import com.api.Inventory.models.recipeitem.RecipeItem;
import com.api.Inventory.models.recipeitem.RecipeItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecipeService {
    private final RecipeRepository _db;
    private final RecipeItemRepository ri;
    private final InventoryItemRepository inv;

    public RecipeService(RecipeRepository repo, RecipeItemRepository ri, InventoryItemRepository inv) {
        this._db = repo;
        this.ri = ri;
        this.inv = inv;
    }

    public void add(Recipe recipe) {
        _db.save(recipe);
    }

    public List<Recipe> getAll() {
        return _db.findAll();
    }

    public Map<String, Object> getById(Long id) {
        Map<String, Object> payload = new HashMap<>();

        Recipe recipe = _db.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found with id: " + id));

        payload.put("id", recipe.getId());
        payload.put("name", recipe.getRecipeName());

        List<RecipeItem> recipeItems = ri.findByRecipeId(id);
        List<Object> ingredients = new ArrayList<>();

        for (RecipeItem ri : recipeItems) {
            Map<String, Object> item = new HashMap<>();
            Long itemId = ri.getInventoryItem();
            float quantity = ri.getQuantity();
            InventoryItem inventory = inv.findById(itemId)
                    .orElseThrow(() -> new RuntimeException("InventoryItem not found with id: " + itemId));
            item.put("quantity", quantity);
            item.put("item", inventory);
            ingredients.add(item);
        }

        payload.put("items", ingredients);

        return payload;
    }
}
