package com.example.springdatajpa.oneToMany;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Dto {

	private String catName;
	
	private List<Product1> prod;

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public List<Product1> getProd() {
		return prod;
	}

	public void setProd(List<Product1> prod) {
		this.prod = prod;
	}

	
	
}
