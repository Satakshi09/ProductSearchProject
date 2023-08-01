package com.product.io;

import java.util.List;

import com.product.model.Product;

public class Output {
	/**
	 * Display result of available Products
	 * 
	 * @param products
	 * @param inputNumber
	 */
	public static void displayResult(List<Product> products, int inputNumber) {
		if (products.size() == 0) {
			System.out.println("Input No: " + inputNumber);
			System.err.println("Product is not present\n");
		} else {
			System.out.println("Input No: " + inputNumber);
			int count = 0;
			for (Product product : products) {
				if (product.getAvailability() == 'Y') {

					if (count == 0) {
						System.out.printf("%-10s%-20s%-40s%-10s%-10s%-10s%-10s%-10s%-10s\n", "S.No.", "ID", "Name",
								"Color", "Gender", "Size", "Price", "Rating", "Availability");
						System.out.println(
								"----------------------------------------------------------------------------------------------------------------------------------------");
					}
					System.out.printf("%-10d", ++count);
					System.out.printf("%-20s", product.getId());
					System.out.printf("%-40s", product.getName());
					System.out.printf("%-10s", product.getColour());
					System.out.printf("%-10s", product.getGender());
					System.out.printf("%-10s", product.getSize());
					System.out.printf("%-10.2f", product.getPrice());
					System.out.printf("%-10.2f", product.getRating());
					System.out.printf("%-10s", product.getAvailability());
					System.out.println();
				} else {
					System.out.println("Product is not available");
				}
			}
			System.out.println();
		}
	}

}
