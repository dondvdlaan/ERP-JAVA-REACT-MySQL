package dev.manyroads.Inventory;

import dev.manyroads.Inventory.domain.Product;
import dev.manyroads.Inventory.rest.repository.ProductRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductRepository productRepository) {
		return (args) -> {

			// Fill up DB with test products
			for (int i = 0; i < 10; i++) {

				String pName = "Prodname " + Integer.toString(i);
				Long pPrice = (long) 100 + i;
				Integer pStock = 100 * (i + 1);

				Product p = new Product(pName, pPrice,pStock );

				System.out.println("test products: " + p.toString());

				productRepository.save(p);
			};
		};
	}
}
