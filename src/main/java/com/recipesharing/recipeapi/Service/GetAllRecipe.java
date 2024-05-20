package com.recipesharing.recipeapi.Service;

import java.lang.Integer;

import org.springframework.boot.autoconfigure.SpringBootApplication;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SpringBootApplication
@Getter
@Setter
@NoArgsConstructor
public class GetAllRecipe {

    private Integer recipeID;
    private String description;
    private String recipeName;



    public GetAllRecipe(Integer recipeID, String recipeName, String description) {

        this.recipeID = recipeID;
        this.description = description;
        this.recipeName = recipeName;
    }

}
