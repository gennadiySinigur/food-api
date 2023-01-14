package com.gennadiysinigur.foodapi.repositories;

import com.gennadiysinigur.foodapi.models.MyRecipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MyRecipeRepository extends JpaRepository<MyRecipe, UUID> {
}
