package com.coderscampus.Assignment9.controller;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.Assignment9.domain.Recipe;
import com.coderscampus.Assignment9.repository.RecipeRepo;
import com.coderscampus.Assignment9.service.RecipeSorterService;

@RestController

public class Assignment9Controller {
	@Autowired
	private RecipeSorterService service;
	private RecipeRepo recipeRepo;

	@GetMapping("gluten-free")
	public List<String> isGlutenFree(List<Recipe> listOfRecipes) {

		List<String> glutenFree = listOfRecipes.stream().filter(newRecipe -> newRecipe.getGlutenFree())
				.map(newRecipe -> newRecipe.getTitle()).collect(Collectors.toList());
		return glutenFree;

	}

	@GetMapping("/all-recipes")
	public List<Recipe> allRecipes() {

		return recipeRepo.findAll();
	}

	@GetMapping("/vegan")
	public List<Recipe> veganRecipes(List<Recipe> listOfRecipes) {

		List<String> vegan = listOfRecipes.stream().filter(newRecipe -> newRecipe.getVegan())
				.map(newRecipe -> newRecipe.getTitle()).collect(Collectors.toList());
		return null;
	}

	@GetMapping("/vegan-and-gluten-free")
	public List<String> veganPlusGluten() {

		List<Recipe> listOfRecipes = service.listOfRecipes;
		List<String> sortedList = listOfRecipes.stream().filter(newRecipe -> newRecipe.getGlutenFree())
				.filter(newRecipe -> newRecipe.getVegan()).map(newRecipe -> newRecipe.getTitle())
				.collect(Collectors.toList());
		System.out.println(sortedList);
		return null;

	}

	@GetMapping("/vegetarian")
	public List<String> vegetarian() {

		List<Recipe> listOfRecipes = service.listOfRecipes;
		List<String> sortedList = listOfRecipes.stream().filter(newRecipe -> newRecipe.getVegetarian())
				.map(newRecipe -> newRecipe.getTitle()).collect(Collectors.toList());
		return sortedList;
	}
}