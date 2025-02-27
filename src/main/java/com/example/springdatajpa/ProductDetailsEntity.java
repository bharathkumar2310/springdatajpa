package com.example.springdatajpa;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Id;

@Entity
public class ProductDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	@OneToOne(mappedBy = "pDetailsEntity", cascade = CascadeType.ALL)
	@JsonBackReference
	private ProductEntity pEntity;

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductEntity getpEntity() {
		return pEntity;
	}

	public void setpEntity(ProductEntity pEntity) {
		this.pEntity = pEntity;
	}
	
	
}
