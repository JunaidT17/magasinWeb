package com.example.projet.repository;

import com.example.projet.entity.Category;
import com.example.projet.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductByName(String name);
}

