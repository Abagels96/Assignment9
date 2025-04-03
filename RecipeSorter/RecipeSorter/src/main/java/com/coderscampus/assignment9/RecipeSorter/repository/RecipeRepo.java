package com.coderscampus.assignment9.RecipeSorter.repository;

import com.coderscampus.assignment9.RecipeSorter.RecipeSorterApplication;
import com.coderscampus.recipesorter.domain.Recipe;
import com.coderscampus.recipesorter.service.RecipeSorterService;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;

public class RecipeRepo {
	@Autowired
	public RecipeSorterService service = new RecipeSorterService();

	public List<Recipe> findAll() {
		List<Recipe> allRecipes = service.listOfRecipes;

		return service.returnRecipes(allRecipes);
	}

}
