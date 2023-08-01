package com.product.io;

import java.util.Scanner;

import com.product.constant.Constant;
import com.product.model.Product;

public class Input {
	Scanner scanner;

	public Input(Scanner scanner) {
		this.scanner = scanner;
	}

	/**
	 * Input product colour
	 * 
	 * @param product
	 */
	private void inputColour(Product product) {
		System.out.print("Enter Product Colour: ");
		product.setColour(scanner.next().toUpperCase());
	}

	/**
	 * Input product size
	 * 
	 * @param product
	 */
	private void inputSize(Product product) {
		System.out.print("Enter Product Size (S, M, L, XL, XXL) : ");
		product.setSize(scanner.next().toUpperCase());
	}

	/**
	 * Input gender for product
	 * 
	 * @param product
	 */
	private void inputGender(Product product) {
		System.out.print("Enter Product Gender (M, F, U) : ");
		product.setGender(scanner.next().toUpperCase());
	}

	/**
	 * Get output preference either user input, number or output preference
	 * 
	 * @param outputPreferenceNumber
	 * @return
	 */
	private String getOutputPreference(String outputPreferenceNumber) {
		String outputPreference = "";
		switch (outputPreferenceNumber.toUpperCase()) {
		case "1":
			outputPreference = Constant.OUTPUT_PREFERENCE.PRICE.toString();
			break;

		case "2":
			outputPreference = Constant.OUTPUT_PREFERENCE.RATING.toString();
			break;

		case "3":
			outputPreference = Constant.OUTPUT_PREFERENCE.BOTH.toString();
			break;

		case "PRICE":
			outputPreference = Constant.OUTPUT_PREFERENCE.PRICE.toString();
			break;

		case "RATING":
			outputPreference = Constant.OUTPUT_PREFERENCE.RATING.toString();
			break;

		case "BOTH":
			outputPreference = Constant.OUTPUT_PREFERENCE.BOTH.toString();
			break;

		default:
			System.out.println("Wrong Selection");
			break;
		}

		return outputPreference;
	}

	/**
	 * Input outputPreference sort by price or sort by rating or both price as well
	 * as rating
	 * 
	 * @param product
	 */
	private void inputOutputPreference(Product product) {
		System.out.println("Enter Output Preferences Sorted by:\n" + "1.Price\n" + "2.Rating\n" + "3.Both");
		String outputPreference = getOutputPreference(scanner.next());
		product.setOutputPerference(outputPreference);
	}

	/**
	 * Get all inputs for Product details
	 * 
	 * @return
	 */
	public Product userInput() {

//		char choice = 'y';
//		ArrayList<Product> products = new ArrayList<Product>();
//		do {
		Product product = new Product();
		inputColour(product);
		inputSize(product);
		inputGender(product);
		inputOutputPreference(product);
//			products.add(product);
//			System.out.print("Search more product (y/n): ");
//			choice = scanner.next().charAt(0);
//			System.out.println();
//		} while (choice == 'Y' || choice == 'y');
//		scanner.close();
		return product;
	}
}
