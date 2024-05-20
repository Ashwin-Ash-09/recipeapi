package com.recipesharing.recipeapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.recipesharing.recipeapi.Model.Recipe;
import com.recipesharing.recipeapi.Service.RecipeService;

import java.util.Map;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public Map<String, Object> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    public Object getRecipeById(@PathVariable Integer id) {

        return recipeService.getRecipeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.saveRecipe(recipe);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Integer id, @RequestBody Recipe recipeDetails) throws Exception {
       if (recipeService.getRecipeById(id).isPresent()){
            Recipe updatedRecipe = recipeService.updateRecipe(id, recipeDetails);
            return ResponseEntity.ok(updatedRecipe);
       }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRecipe(@PathVariable Integer id) {
        if (recipeService.getRecipeById(id).isPresent()) {
            recipeService.deleteRecipe(id);

            return  ResponseEntity.ok("The Resipie is deleted");

        }
        return ResponseEntity.badRequest().build();

    }
}
