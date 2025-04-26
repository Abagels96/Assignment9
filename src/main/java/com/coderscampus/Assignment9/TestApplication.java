package com.coderscampus.Assignment9;

import java.io.FileNotFoundException;

import com.coderscampus.Assignment9.service.Assignment9Service;

public class TestApplication {

	public static void main(String[] args) throws FileNotFoundException {

		Assignment9Service service = new  Assignment9Service();
		
		service.readFile();
		service.returnRecipes(service.listOfRecipes);
		
		
		
	}

}
