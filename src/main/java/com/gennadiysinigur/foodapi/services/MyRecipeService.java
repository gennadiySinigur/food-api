package com.gennadiysinigur.foodapi.services;

import com.gennadiysinigur.foodapi.models.MyRecipe;

import java.util.List;
import java.util.UUID;

public interface MyRecipeService {
    void saveRecipe(MyRecipe recipe);

    List<MyRecipe> getAllRecipes();

    MyRecipe getRecipeById(UUID id);

    MyRecipe updateRecipe(UUID id, MyRecipe updatedRecipe);
}
