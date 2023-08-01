package com.product.impl;

import java.util.Comparator;

import com.product.model.Product;

public class ComparePrice implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		if (o1.getPrice() < o2.getPrice())
			return -1;
		else if (o1.getPrice() > o2.getPrice())
			return 1;
		else
			return 0;
	}

}
