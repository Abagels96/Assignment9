package main.java.com.coderscampus.assignment9.web;

import java.util.List;
import java.util.stream.Collectors;

import main.java.com.coderscampus.assignment9.domain.Recipe;
import main.java.com.coderscampus.assignment9.repository.RecipeRepo;
import main.java.com.coderscampus.rassignment9.service.RecipeSorterService;

@RestController

public class RecipeSorterController {
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