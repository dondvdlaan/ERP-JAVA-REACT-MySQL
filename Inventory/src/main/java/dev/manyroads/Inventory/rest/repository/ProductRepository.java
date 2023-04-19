package dev.manyroads.Inventory.rest.repository;


import dev.manyroads.Inventory.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
