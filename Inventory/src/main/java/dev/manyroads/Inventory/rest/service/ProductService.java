package dev.manyroads.Inventory.rest.service;

import dev.manyroads.Inventory.constants.OrderStatus;
import dev.manyroads.Inventory.domain.LineItem;
import dev.manyroads.Inventory.domain.Orders;
import dev.manyroads.Inventory.domain.Product;
import dev.manyroads.Inventory.rest.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Class to provide services for the ProductConroller
 */
@Service
public class ProductService {

    // Attributes
    @Autowired
    ProductRepository productRepository;

    // ---- Methods ----
    /**
     * Method for checking and adjusting stock level for each lineItem
     *
     * @param order         : Order received from order-service to be processed
     * @return orderStatus  : Order status message
     */
    @Transactional
    public Orders handleOrder(Orders order) {

        // --- variables ---
        Orders confirmedOrder = new Orders();

        // Extract from LineItems each product
        order.getLineItems().forEach(l -> {

            Product p = getProduct(l);

            // Checking stock level against request
            if (p.getProdStock() >= l.getProdQuantity()) {

                // Adjusting stock level and saving to DB
                p.setProdStock(p.getProdStock() - l.getProdQuantity());
                productRepository.save(p);

            } else {
                throw new RuntimeException("Product is out of stock: " + l.getProdID());
                    }
            }
        );
        // Confirm successful stock checking
        confirmedOrder = order.setOrderStatus(OrderStatus.SUCCESS);

        System.out.println(" confirmedOrder: " +  confirmedOrder);

        return confirmedOrder;
    }

    /**
     * Method for resetting and adjusting stock level for each lineItem
     *
     * @param order         : Order received from order-service to be processed
     * @return orderStatus  : Order status message
     */
    @Transactional
    public Orders revertOrder(Orders order) {
        
        order.getLineItems().forEach(l -> {
                    
            Product p = getProduct(l);

            // Stock level is restored and saved
            p.setProdStock(p.getProdStock() + l.getProdQuantity());
            productRepository.save(p);
        });

        return order.setOrderStatus(OrderStatus.SUCCESS);
    }

    /**
     * Find all products in DB
     *
     * @return Iterable List    : List of Products
     */
    public @ResponseBody Iterable getProducts() {

        Iterable<Product> allProducts = productRepository.findAll();

        for(Product p : allProducts){
            System.out.println(p.toString());
        }
        return productRepository.findAll();
    }

    // Sub methods

    /**
     * Finds Product that belongs to each lineItem
     *
     * @param l         : lineItem
     * @return Product  : Product is returned
     */
    private Product getProduct(LineItem l) {

        return productRepository.findById(l.getProdID())
                .orElseThrow(() -> new RuntimeException("Could not find the product: " + l.getProdID()));
    }



}
