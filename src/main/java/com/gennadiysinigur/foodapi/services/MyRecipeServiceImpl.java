package com.gennadiysinigur.foodapi.services;

import com.gennadiysinigur.foodapi.models.MyRecipe;
import com.gennadiysinigur.foodapi.repositories.MyRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyRecipeServiceImpl implements MyRecipeService {
    @Autowired
    private MyRecipeRepository myRecipeRepository;

    @Override
    public void saveRecipe(MyRecipe recipe) {
        myRecipeRepository.save(recipe);
    }

    @Override
    public List<MyRecipe> getAllRecipes() {
        return myRecipeRepository.findAll();
    }
}
