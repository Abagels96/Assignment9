package com.coderscampus.recipesorter.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class RecipeSorterService {

	Recipe recipe = new Recipe();
	Set<Recipe> recipeList = new HashSet<>();
	List<Recipe> listOfRecipes= new ArrayList<>();

//first get the file to parse correctly
	// then add the record.get to each variable in the POJO
	// construct the object and then add all the objects to a set
	// find a way to filter the set by attributes and put mapping on all of them
	public void readFile() throws FileNotFoundException {

	FileReader in = new FileReader("recipes.txt");
	
	
	
	Iterable<CSVRecord> records;
	try {
		records = CSVFormat.DEFAULT.withIgnoreSurroundingSpaces()
				                                       .withHeader()
				                                       .withSkipHeaderRecord()
				                                       .withEscape('\\')
				                                       .parse(in);
		for (CSVRecord record : records) {
		
		System.out.println("the record the program is processing is:"+record+"the number is "+recordCount);
//		System.out.println("the record the program is processing is:"+ record+"the number is "+recordCount);
			Integer cookingMinutes= Integer.parseInt(record.get(0));
			
			
			
			Boolean dairyFree= Boolean.parseBoolean(record.get(1));
			
			Boolean glutenFree= Boolean.parseBoolean(record.get(2));
			
		 String instructions= record.get(3);

		     Double preparationMinutes= Double.parseDouble(record.get(4));

		     Double pricePerServing=Double.parseDouble(record.get(5));
		     

		 Integer readyInMinutes= Integer.parseInt(record.get(6));

		    Integer servings=Integer.parseInt(record.get(7));

		     Double spoonacularScore= Double.parseDouble(record.get(8));

		    String title=record.get(9);
//
		    Boolean vegan=Boolean.parseBoolean(record.get(10));
//
		    Boolean vegetarian=Boolean.parseBoolean(record.get(11));
			
//			i++;
//			System.out.println(i);
			System.out.println("Cooking Minutes are" +cookingMinutes);
			System.out.println("Is it dairy free?" + dairyFree);
			System.out.println("Is it gluten free" + glutenFree);
System.out.println("Here are the instructions"+instructions);			
System.out.println("number of minutes"+preparationMinutes);			
System.out.println("Price per serving"+pricePerServing);			
System.out.println("ready in minutes"+readyInMinutes);			
System.out.println("number of servings"+ servings);			
System.out.println("spoonacular score"+spoonacularScore);			
System.out.println("here is the title"+title);			
System.out.println("is it vegan"+vegan);			
System.out.println("Is it vegetarian"+vegetarian);			
			
addRecipe(cookingMinutes, dairyFree, glutenFree,  instructions, preparationMinutes, pricePerServing, readyInMinutes, servings, spoonacularScore,title, vegan,vegetarian);
		
		}
//		recordCount++;
		
	
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
   }

	public void addRecipe(Integer cookingMinutes, Boolean dairyFree, Boolean glutenFree, String instructions,
			Double preparationMinutes, Double pricePerServing, Integer readyInMinutes, Integer servings,
			Double spoonacularScore, String title, Boolean vegan, Boolean vegetarian) {
		int i=0;
		Recipe newRecipe = new Recipe(cookingMinutes, dairyFree, glutenFree, instructions, preparationMinutes,
				pricePerServing, readyInMinutes, servings, spoonacularScore, title, vegan, vegetarian);
		listOfRecipes.add(newRecipe);
		for(Recipe recipe:listOfRecipes) {
			i++;
			System.out.println(recipe);
			System.out.println(i);
		}
//		recipeList.add(newRecipe);
//		for (Recipe recipe : recipeList) {
//			i++;
//			System.out.println(i);
//			System.out.println(recipe);
//			
//		}
	}
}
