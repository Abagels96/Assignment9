package com.coderscampus.Assignment9.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.coderscampus.Assignment9.domain.Recipe;

@Service
public class Assignment9Service {

	public Recipe recipe = new Recipe();
	public List<Recipe> listOfRecipes = new ArrayList<>();

	public void readFile() throws FileNotFoundException {

		FileReader in = new FileReader("recipes.txt");
		 String HEADERS= "Cooking Minutes, Dairy Free, Gluten Free, Instructions, Preparation Minutes, Price Per Serving, Ready In Minutes, Servings, Spoonacular Score, Title, Vegan, Vegetarian";

		CSVFormat csvFormat;
		try {
			csvFormat = CSVFormat.DEFAULT.builder().setIgnoreSurroundingSpaces(true).setIgnoreEmptyLines(true)        .setHeader(HEADERS)
.setSkipHeaderRecord(true). setEscape('\'').
					setIgnoreHeaderCase(true)
					.setEscape('\\').setQuote('"').setTrim(true).setDelimiter(".").setIgnoreSurroundingSpaces(true).build();
					
					
					//find a way to parse a file reader with builder and make it handle more characters and spaces IG
					//handle the exceptions probably.
			
			Iterable<CSVRecord> records = csvFormat.parse(in);
				

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
				Boolean vegan = Boolean.parseBoolean(record.get(10));
				Boolean vegetarian = Boolean.parseBoolean(record.get(11));

				//fix the file reader to only run once.

				addRecipe(cookingMinutes, dairyFree, glutenFree, instructions, preparationMinutes, pricePerServing,
						readyInMinutes, servings, spoonacularScore, title, vegan, vegetarian);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
System.out.println("File not found");		}

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
