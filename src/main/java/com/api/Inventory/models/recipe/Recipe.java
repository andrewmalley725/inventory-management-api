package com.api.Inventory.models.recipe;

import com.api.Inventory.models.recipeitem.RecipeItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String RecipeName;

    public Recipe() {
    }

    public Long getId() {
        return id;
    }

    public Recipe(String recipeName) {
        RecipeName = recipeName;
    }

    public String getRecipeName() {
        return RecipeName;
    }

    public void setRecipeName(String recipeName) {
        RecipeName = recipeName;
    }

}
