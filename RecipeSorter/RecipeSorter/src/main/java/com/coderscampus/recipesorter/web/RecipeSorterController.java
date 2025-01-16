package com.coderscampus.recipesorter.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.recipesorter.service.Recipe;

@RestController
public class RecipeSorterController {
	
	@GetMapping ("Gluten Free Recipes")
	public List<String> glutenFree(List<Recipe>listOfRecipes){
		
//		listOfRecipes.stream().
		
		
		return null;
		
	}

}
