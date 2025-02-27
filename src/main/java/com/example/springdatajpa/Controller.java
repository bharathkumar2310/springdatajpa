package com.example.springdatajpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	private ProductRepo prodRepo;
	
	@Autowired
	private ProductDetailsRepo prodDetailsRepo;

	@PostMapping("/save")
	public ResponseEntity<?> saveProd(@RequestBody ProductDto prodDto) {
		ProductEntity prod = new ProductEntity();
		prod.setName(prodDto.getName());
		prod.setPrice(prodDto.getPrice());
		
		ProductDetailsEntity prodEntity = new ProductDetailsEntity();
		prodEntity.setDescription(prodDto.getDescription());
		
		prod.setpDetailsEntity(prodEntity);
		
		prodRepo.save(prod);
		return ResponseEntity.ok("product saved successfully");
	}
	
	@PostMapping("/saveDetails")
	public ResponseEntity<?> saveProdDetails(@RequestBody AddressDto addDto) {
		ProductEntity prod = new ProductEntity();
		prod.setName(addDto.getName());
		prod.setPrice(addDto.getPrice());
		
		ProductDetailsEntity prodEntity = new ProductDetailsEntity();
		prodEntity.setDescription(addDto.getDescription());
		
		prodEntity.setpEntity(prod);
		
		prodDetailsRepo.save(prodEntity);
		return ResponseEntity.ok("product Details saved successfully");
	}
	
	@GetMapping("/getProductByName")
	public ResponseEntity<?> getProductByName(@RequestParam String name) {
		ProductEntity prod = prodRepo.findByName(name);
		return ResponseEntity.ok(prod);
	}
	
	@GetMapping("/getProductDetailsById")
	public ResponseEntity<?> getProductDetailsById(@RequestParam Long id) {
		ProductDetailsEntity prodEntity = prodDetailsRepo.findById(id).orElse(null);
		return ResponseEntity.ok(prodEntity);
	}

	@GetMapping("/getProductByNameCQ")
	public ResponseEntity<?> getProductByNameCustomQuery(@RequestParam String name) {
		List<ProductEntity> prod = prodRepo.findByNameCustomQuery(name);
		return ResponseEntity.ok(prod);
	}
	
	
	@GetMapping("/getProductByPrice")
	public ResponseEntity<?> getProductByPriceUsingPaginationAndSorting(@RequestParam Double price, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "4") int size,
																		@RequestParam(defaultValue = "price") String sortBy,  @RequestParam(defaultValue = "asc") String direction) {
		
		Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(page, size, sort);
		
		Page<ProductEntity> prod = prodRepo.findByPrice(pageable, price);
		return ResponseEntity.ok(prod);
	}
}
