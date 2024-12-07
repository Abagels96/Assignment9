package com.coderscampus.recipesorter.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class RecipeSorterService {
	
Recipe recipe= new Recipe();
//first get the file to parse correctly
	//then add the record.get to each variable in the POJO
	//construct the object and then add all the objects to a set 
	// find a way to filter the set by attributes and put mapping on all of them
   public void readFile() throws FileNotFoundException {

	FileReader in = new FileReader("recipes.txt");
	
	
	
	Iterable<CSVRecord> records;
	try {
		records = CSVFormat.DEFAULT.withIgnoreSurroundingSpaces()
				                                       .withHeader()
				                                       .withQuote(null)
				                                       .withSkipHeaderRecord()
				                                       .parse(in);
		for (CSVRecord record : records) {
			Integer cookingMinutes= Integer.parseInt(record.get(0));
			
			
			Boolean dairyFree= Boolean.parseBoolean(record.get(1));
			
			Boolean glutenFree= Boolean.parseBoolean(record.get(2));
			
		 String instructions= record.get(3);
//
		     Double preparationMinutes= Double.parseDouble(record.get(4));
//
		     Double pricePerServing=Double.parseDouble(record.get(5));
		     
//
		 Integer readyInMinutes= Integer.parseInt(record.get(6));
//
		    Integer servings=Integer.parseInt(record.get(7));
//
		     Double spoonacularScore= Double.parseDouble(record.get(8));
//
		    String title=record.get(9);
//
		    Boolean vegan=Boolean.parseBoolean(record.get(10));
//
		    Boolean vegetarian=Boolean.parseBoolean(record.get(11));
			
			
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
			
//Recipe recipe= new Recipe(cookingMinutes,dairyFree,glutenFree,instructions,)
		}
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
   }
	
}
