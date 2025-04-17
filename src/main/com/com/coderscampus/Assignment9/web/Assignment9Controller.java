package com.coderscampus.Assignment9.web;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.Assignment9.domain.Recipe;
import com.coderscampus.Assignment9.service.Assignment9Service;

@RestController

public class Assignment9Controller {
	@Autowired
	private Assignment9Service service;

	@GetMapping("/gluten-free")
	public List<Recipe> isGlutenFree() {
		List<Recipe> allRecipes = allRecipes();
		List<Recipe> glutenFree = allRecipes.stream().filter(newRecipe -> newRecipe.getGlutenFree())
				.collect(Collectors.toList());
		return glutenFree;

	}

	@GetMapping("/all-recipes")
	public List<Recipe> allRecipes() {
		try {
			service.readFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Recipe> allRecipes = service.returnRecipes(service.listOfRecipes);
		return allRecipes;
	}

	@GetMapping("/vegan")
	public List<Recipe> veganRecipes() {

		List<Recipe> allRecipes = allRecipes();
		List<Recipe> vegan = allRecipes.stream().filter(newRecipe -> newRecipe.getVegan())
				.collect(Collectors.toList());
		return vegan;
	}

	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> veganPlusGluten() {
		List<Recipe> allRecipes = allRecipes();

		List<Recipe> veganAndGluten = allRecipes.stream().filter(newRecipe -> newRecipe.getGlutenFree()
				||  newRecipe.getVegan())
				.collect(Collectors.toList());
		return veganAndGluten;

	}

	@GetMapping("/vegetarian")
	public List<Recipe> vegetarian() {
		List<Recipe> allRecipes = allRecipes();

		List<Recipe> sortedList = allRecipes.stream().filter(newRecipe -> newRecipe.getVegetarian())
				.collect(Collectors.toList());
		return sortedList;
	}
}