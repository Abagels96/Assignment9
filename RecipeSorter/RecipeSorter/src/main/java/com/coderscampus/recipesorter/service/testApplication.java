package com.coderscampus.recipesorter.service;

import java.io.FileNotFoundException;

public class testApplication {

	public static void main(String[] args) throws FileNotFoundException {

		
		RecipeSorterService service= new RecipeSorterService();
		
		service.readFile();
	}

}
