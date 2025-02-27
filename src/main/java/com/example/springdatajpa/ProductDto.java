package com.example.springdatajpa;

import org.springframework.stereotype.Component;

@Component
public class ProductDto {
	
	private String name;
	
	private double price;
	
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescrription(String description) {
		this.description = description;
	}
	
	
	
}
