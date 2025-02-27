package com.example.springdatajpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Long>{
	
	ProductEntity findByName(String name);
	
	@Query("SELECT p FROM ProductEntity p WHERE p.name = ?1")
    List<ProductEntity> findByNameCustomQuery(String name);
	
	
	Page<ProductEntity> findByPrice(Pageable pageable, Double price);

}
