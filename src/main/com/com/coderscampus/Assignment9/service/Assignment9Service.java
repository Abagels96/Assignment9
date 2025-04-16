package com.coderscampus.Assignment9.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.coderscampus.Assignment9.repository.*;
import com.coderscampus.Assignment9.domain.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment9.domain.Recipe;
//import com.coderscampus.Assignment9.repository.RecipeRepo;

@Service
public class Assignment9Service {

	public Recipe recipe = new Recipe();
	public List<Recipe> listOfRecipes = new ArrayList<>();

	@Autowired
//	RecipeRepo recipeRepo;

	@SuppressWarnings("deprecation")
	public void readFile() throws FileNotFoundException {

		FileReader in = new FileReader("recipes.txt");

		Iterable<CSVRecord> records;
		try {
			records = CSVFormat.DEFAULT.withIgnoreSurroundingSpaces().withHeader().withSkipHeaderRecord(true)
					.withTrim(true).withQuote('"').withEscape('\\').withIgnoreSurroundingSpaces(true)
					
					.parse(in);

			for (CSVRecord record : records) {

				Integer cookingMinutes = Integer.parseInt(record.get(0));

				Boolean dairyFree = Boolean.parseBoolean(record.get(1));

				Boolean glutenFree = Boolean.parseBoolean(record.get(2));

				String instructions = record.get(3);

				Double preparationMinutes = Double.parseDouble(record.get(4));

				Double pricePerServing = Double.parseDouble(record.get(5));

				Integer readyInMinutes = Integer.parseInt(record.get(6));

				Integer servings = Integer.parseInt(record.get(7));

				Double spoonacularScore = Double.parseDouble(record.get(8));

				String title = record.get(9);
//
				Boolean vegan = Boolean.parseBoolean(record.get(10));
//
				Boolean vegetarian = Boolean.parseBoolean(record.get(11));

				System.out.println("Is it gluten free" + glutenFree);
				System.out.println("Here are the instructions" + instructions);

				addRecipe(cookingMinutes, dairyFree, glutenFree, instructions, preparationMinutes, pricePerServing,
						readyInMinutes, servings, spoonacularScore, title, vegan, vegetarian);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Recipe> addRecipe(Integer cookingMinutes, Boolean dairyFree, Boolean glutenFree, String instructions,
			Double preparationMinutes, Double pricePerServing, Integer readyInMinutes, Integer servings,
			Double spoonacularScore, String title, Boolean vegan, Boolean vegetarian) {
		Recipe newRecipe = new Recipe(cookingMinutes, dairyFree, glutenFree, instructions, preparationMinutes,
				pricePerServing, readyInMinutes, servings, spoonacularScore, title, vegan, vegetarian);

		listOfRecipes.add(newRecipe);
		return listOfRecipes;

	}

	public List<Recipe> returnRecipes(List<Recipe> listOfRecipes) {
		return listOfRecipes;

	}
}
