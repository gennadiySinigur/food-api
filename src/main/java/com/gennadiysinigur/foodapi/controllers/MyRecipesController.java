package com.gennadiysinigur.foodapi.controllers;

import com.gennadiysinigur.foodapi.models.MyRecipe;
import com.gennadiysinigur.foodapi.services.MyRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/my-recipes")
@CrossOrigin(origins = "http://localhost:4200")
public class MyRecipesController {
    @Autowired
    private MyRecipeService myRecipeService;

    @PostMapping("/add")
    public void add(@RequestBody MyRecipe recipe) {
        myRecipeService.saveRecipe(recipe);
    }

    @GetMapping
    public List<MyRecipe> getAll() {
        return myRecipeService.getAllRecipes();
    }
}
