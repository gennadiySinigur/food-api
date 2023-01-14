package com.gennadiysinigur.foodapi.services;

import com.gennadiysinigur.foodapi.models.MyRecipe;

import java.util.List;

public interface MyRecipeService {
    void saveRecipe(MyRecipe recipe);

    List<MyRecipe> getAllRecipes();
}
