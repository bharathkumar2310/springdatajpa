package com.example.springdatajpa.oneToMany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Product1Repo extends JpaRepository<Product1, Long> {

}
