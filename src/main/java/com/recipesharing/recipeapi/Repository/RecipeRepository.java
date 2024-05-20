package com.recipesharing.recipeapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipesharing.recipeapi.Model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

}
