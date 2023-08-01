package com.product.constant;

public class Constant {
	public static final String FILES_PATH = System.getProperty("user.dir") + "\\CSV_files";
	public static final int DELAY = 500;
	public static final int PERIOD = 5000;

	public enum SIZES {
		S, M, L, XL, XXL
	};

	public enum OUTPUT_PREFERENCE {
		PRICE, RATING, BOTH;
	}

}
