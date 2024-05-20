package com.recipesharing.recipeapi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipesharing.recipeapi.Model.Recipe;
import com.recipesharing.recipeapi.Repository.RecipeRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Map<String, Object> getAllRecipes() {
        List<Recipe> recipes = recipeRepository.findAll();
        List<GetAllRecipe> allRecipes = new ArrayList<>();
        for (Recipe recipe : recipes) {
            allRecipes.add(new GetAllRecipe(recipe.getRecipeID(), recipe.getName(), recipe.getDescription()));
        }
        Map<String, Object> response = new LinkedHashMap<String, Object>();

        response.put("recipes", allRecipes);
        return response;
    }

    public Optional<Recipe> getRecipeById(Integer id) {
        return recipeRepository.findById(id);
    }

    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(Integer id) {
        recipeRepository.deleteById(id);
    }

    public Recipe updateRecipe(Integer id, Recipe recipeDetails) throws Exception {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
        if (optionalRecipe.isPresent()) {
            Recipe recipe = optionalRecipe.get();
            recipe.setName(recipeDetails.getName());
            recipe.setDescription(recipeDetails.getDescription());
            // set other fields as needed
            return recipeRepository.save(recipe);
        } else {
            throw new Exception("Recipe not found with id " + id);
        }
    }
}
