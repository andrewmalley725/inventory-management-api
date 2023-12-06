package com.api.Inventory.controllers;

import com.api.Inventory.models.recipe.RecipeService;
import com.api.Inventory.models.recipe.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RecipeController {
    private final RecipeService _db;

    @Autowired
    public RecipeController(RecipeService temp) {
        this._db = temp;
    }

    @GetMapping("/recipes")
    public List<Recipe> Base() {
        return _db.getAll();
    }

    @GetMapping("/recipes/{id}")
    public Map<String, Object> getById(@PathVariable("id") Long id) {
        return _db.getById(id);
    }

    @PostMapping("/new-recipe")
    public Recipe newRecipe(@RequestBody Recipe recipe) {
        _db.add(recipe);
        return recipe;
    }
}
