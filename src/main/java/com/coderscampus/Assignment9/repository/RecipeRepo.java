package main.java.com.coderscampus.assignment9.repository;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import main.java.com.coderscampus.assignment9.domain.Recipe;
import main.java.com.coderscampus.rassignment9.service.RecipeSorterService;

public class RecipeRepo {
	@Autowired
	public RecipeSorterService service = new RecipeSorterService();

	public List<Recipe> findAll() {
		List<Recipe> allRecipes = service.listOfRecipes;

		return service.returnRecipes(allRecipes);
	}

}
