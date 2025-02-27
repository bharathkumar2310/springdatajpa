package com.example.springdatajpa.oneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerClass {
	
	@Autowired
	CategoryRepo catRepo;
	
	@Autowired
	Product1Repo prodRepo;

	@PostMapping("/saveCategory")
	private String saveCategory(@RequestBody Dto dto) {
		
		Category cat = new Category();
		cat.setName(dto.getCatName());
		cat.setProduct(dto.getProd());
		
		for (Product1 prod : dto.getProd()) {
	        prod.setCategory(cat);  // ✅ Assign category to each product
	    }
		
		catRepo.save(cat);
		return "category saved";
	}
	
	@PostMapping("/saveProduct")
	private String saveProduct(@RequestBody ProdDto dto) {
		
		Product1 prod = new Product1();
		prod.setName(dto.getProdName());
		
		Category cat = new Category();
		cat.setName(dto.getCatName());
		
		prod.setCategory(cat);
		
		prodRepo.save(prod);
		
		
		return "product saved";
	}
	
	@GetMapping("/fetchCategory")
	private Category fetchCategory(@RequestParam Long id) {
		return catRepo.findById(id).orElse(null);
	}
	
	@GetMapping("/fetchProduct")
	private Product1 fetchProduct(@RequestParam Long id) {
		Product1 prod = prodRepo.findById(id).orElse(null);
		System.out.println(prod.getCategory().getName());
		return prod;
	}
}
