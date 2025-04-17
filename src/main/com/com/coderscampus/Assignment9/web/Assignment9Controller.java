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

	// sync the names of the classes before turning into Kevin
	@GetMapping("/gluten-free")
	public List<String> isGlutenFree() {
		List<Recipe> allRecipes = allRecipes();
		List<String> glutenFree = allRecipes.stream().filter(newRecipe -> newRecipe.getGlutenFree())
				.map(newRecipe -> newRecipe.getTitle()).collect(Collectors.toList());
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
	public List<String> veganRecipes() {

		List<Recipe> allRecipes = allRecipes();
		List<String> vegan = allRecipes.stream().filter(newRecipe -> newRecipe.getVegan())
				.map(newRecipe -> newRecipe.getTitle()).collect(Collectors.toList());
		return vegan;
	}

	@GetMapping("/vegan-and-gluten-free")
	public List<String> veganPlusGluten() {
		List<Recipe> allRecipes = allRecipes();

		List<String> veganAndGluten = allRecipes.stream().filter(newRecipe -> newRecipe.getGlutenFree()
				||  newRecipe.getVegan()).map(newRecipe -> newRecipe.getTitle())
				.collect(Collectors.toList());
		System.out.println(veganAndGluten);
		return veganAndGluten;

	}

	@GetMapping("/vegetarian")
	public List<String> vegetarian() {
		List<Recipe> allRecipes = allRecipes();

		List<String> sortedList = allRecipes.stream().filter(newRecipe -> newRecipe.getVegetarian())
				.map(newRecipe -> newRecipe.getTitle()).collect(Collectors.toList());
		return sortedList;
	}
}