package com.gennadiysinigur.foodapi.controllers;

import com.gennadiysinigur.foodapi.models.MyRecipe;
import com.gennadiysinigur.foodapi.services.MyRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public ResponseEntity<MyRecipe> getById(@PathVariable("id")UUID id) {
        Optional<MyRecipe> myRecipe = Optional.ofNullable(myRecipeService.getRecipeById(id));

        return myRecipe
                .map(recipe -> new ResponseEntity<>(recipe, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<MyRecipe> update(
            @PathVariable("id") UUID id,
            @RequestBody MyRecipe updatedRecipe
    ) {
        MyRecipe myRecipe = myRecipeService.updateRecipe(id, updatedRecipe);

        return new ResponseEntity<>(myRecipe, HttpStatus.OK);
    }
}
