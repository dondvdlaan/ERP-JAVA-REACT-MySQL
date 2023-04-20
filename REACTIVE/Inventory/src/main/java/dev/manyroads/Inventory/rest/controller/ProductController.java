package dev.manyroads.Inventory.rest.controller;

import dev.manyroads.Inventory.domain.Orders;
import dev.manyroads.Inventory.domain.Product;
import dev.manyroads.Inventory.rest.repository.ProductRepository;
import dev.manyroads.Inventory.rest.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
//@CrossOrigin(origins = "*")
@RequestMapping("/api/products")
public class ProductController {

    // Attributes
    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    // ---- Routes ----
    @GetMapping("/test")
    public void testInventory(){
        Product pTest = new Product("TestName2", 20L, 2000);
        productRepository.save(pTest);
        System.out.printf(pTest.toString());
    }

    /**
     * Returns all products
     * @return
     */
    @GetMapping("/allProducts")
    public Iterable<Product> getAllProducts() {

        return productService.getProducts();
    }

    /**
     * Method for Handling of new order
     * @param order
     * @return
     */
    @PostMapping
    public Orders processOrder(@RequestBody Orders order) {

        System.out.println("Route: Inventory processOrder");

        return productService.handleOrder(order);
    }

    @DeleteMapping
    public Orders revertOrder(@RequestBody Orders order) {

        return productService.revertOrder(order);
    }

}
