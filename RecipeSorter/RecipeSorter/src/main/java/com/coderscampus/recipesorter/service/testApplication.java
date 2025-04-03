package com.coderscampus.recipesorter.service;

import java.io.FileNotFoundException;

import com.coderscampus.recipesorter.web.RecipeSorterController;

public class testApplication {

	public static void main(String[] args) throws FileNotFoundException {

		
		RecipeSorterService service= new RecipeSorterService();
		RecipeSorterController controller= new RecipeSorterController();
		
		
		service.readFile();
		controller.allRecipes();
	}

}
