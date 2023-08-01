package com.product.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.product.constant.Constant;
import com.product.io.Output;
import com.product.model.Product;

public class SearchProduct {
	/**
	 * Search whether user input product available or not
	 * 
	 * @param filesData
	 * @param products
	 */
	public static void searchProductForUser(List<Product> filesData, Product product, int inputNumber) {
//		for (Product product : products) {
		List<Product> productsResult = filesData.stream()
				.filter(fileData -> fileData.getColour().equalsIgnoreCase(product.getColour())
						&& fileData.getSize().equalsIgnoreCase(product.getSize())
						&& fileData.getGender().equalsIgnoreCase(product.getGender()))
				.collect(Collectors.toList());
		if (product.getOutputPerference().equalsIgnoreCase(Constant.OUTPUT_PREFERENCE.PRICE.toString())) {
			Collections.sort(productsResult, new ComparePrice());
		} else if (product.getOutputPerference().equalsIgnoreCase(Constant.OUTPUT_PREFERENCE.RATING.toString())) {
			Collections.sort(productsResult, new CompareRating());
		} else {
			Collections.sort(productsResult, new CompareBothPriceAndRating());
		}
		Output.displayResult(productsResult, inputNumber);
//		}
	}
}
