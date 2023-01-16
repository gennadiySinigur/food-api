package com.gennadiysinigur.foodapi.services;

import com.gennadiysinigur.foodapi.models.MyRecipe;
import com.gennadiysinigur.foodapi.repositories.MyRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MyRecipeServiceImpl implements MyRecipeService {
    @Autowired
    private MyRecipeRepository myRecipeRepository;

    @Override
    public MyRecipe saveRecipe(MyRecipe recipe) {
        myRecipeRepository.save(recipe);

        return recipe;
    }

    @Override
    public List<MyRecipe> getAllRecipes() {
        return myRecipeRepository.findAll();
    }

    @Override
    public MyRecipe getRecipeById(UUID id) {
        Optional<MyRecipe> myRecipe = myRecipeRepository.findById(id);

        return myRecipe.orElse(null);
    }

    @Override
    public MyRecipe updateRecipe(UUID id, MyRecipe updatedRecipe) {
        Optional<MyRecipe> myRecipe = myRecipeRepository.findById(id);

        if (myRecipe.isPresent()) {
            MyRecipe recipeToUpdate = myRecipe.get();

            recipeToUpdate.setTitle(updatedRecipe.getTitle());
            recipeToUpdate.setCategory(updatedRecipe.getCategory());
            recipeToUpdate.setImageAddress(updatedRecipe.getImageAddress());
            recipeToUpdate.setIngredients(updatedRecipe.getIngredients());
            recipeToUpdate.setInstruction(updatedRecipe.getInstruction());

            myRecipeRepository.save(recipeToUpdate);

            return recipeToUpdate;
        }

        return null;
    }
}
