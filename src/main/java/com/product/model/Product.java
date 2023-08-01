package com.product.model;

public class Product {
	private String id;
	private String name;
	private String colour;
	private String gender;
	private String size;
	private double price;
	private double rating;
	private char availability;
	private String outputPerference;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public char getAvailability() {
		return availability;
	}

	public void setAvailability(char availability) {
		this.availability = availability;
	}

	public String getOutputPerference() {
		return outputPerference;
	}

	public void setOutputPerference(String outputPerference) {
		this.outputPerference = outputPerference;
	}

}
