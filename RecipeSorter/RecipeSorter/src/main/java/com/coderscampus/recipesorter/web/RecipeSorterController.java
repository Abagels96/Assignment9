package com.coderscampus.recipesorter.web;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.recipesorter.domain.Recipe;

@RestController

public class RecipeSorterController {
	@Autowired
	Recipe recipe;
	
	@GetMapping ("Gluten Free Recipes")
	public List<String> glutenFree(List<Recipe>listOfRecipes){
		
	List<Recipe> sortedList=	listOfRecipes.stream().filter(gluten-> recipe.getGlutenFree()).collect(Collectors.toList());
		
		System.out.println(sortedList);
		return null;
		
	}

}
