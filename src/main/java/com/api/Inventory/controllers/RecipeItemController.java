package com.api.Inventory.controllers;

import com.api.Inventory.models.recipeitem.RecipeItem;
import com.api.Inventory.models.recipeitem.RecipeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RecipeItemController {
    private final RecipeItemService _db;

    @Autowired
    public RecipeItemController(RecipeItemService temp) {
        this._db = temp;
    }

    @GetMapping("/recipe-items")
    public List<RecipeItem> Base() {
        return _db.getAll();
    }

    @PostMapping("/new-recipe-item")
    public Map<String, Object> newItem(@RequestBody RecipeItem newItem) {
       return _db.add(newItem);
    }
}
