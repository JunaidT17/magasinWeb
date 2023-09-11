package com.example.projet;

import com.example.projet.entity.Product;
import com.example.projet.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


	@SpringBootApplication
	public class ProjetApplication implements CommandLineRunner {
		@Autowired
		private ProductRepository productRepository;

		public static void main(String[] args) {
			SpringApplication.run(ProjetApplication.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
			Product product1 = new Product();
			product1.setName("Basket");
			product1.setPrice(90);

			Product product2 = new Product();
			product2.setName("Casquette");
			product2.setPrice(35);

			productRepository.save(product1);
			productRepository.save(product2);
		}

	}
