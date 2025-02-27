package com.example.springdatajpa.oneToMany;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name; 
	
	@OneToMany(mappedBy = "category", cascade= CascadeType.ALL)
	@JsonManagedReference


	List<Product1>product;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product1> getProduct() {
		return product;
	}

	public void setProduct(List<Product1> product) {
		this.product = product;
	}
	
	
}
