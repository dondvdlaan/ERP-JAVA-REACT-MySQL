package dev.manyroads.Order.rest.service;

import dev.manyroads.Order.constants.OrderStatus;
import dev.manyroads.Order.domain.Orders;
import dev.manyroads.Order.rest.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    // Methods
    public Orders createOrder(Orders newOrder) {

        // Variables
        boolean success             = true;
        Orders inventoryResponse    = null;
        Orders shippingResponse     = null;
        RestTemplate restTemplate   = new RestTemplate();
        String inventoryServiceUrl  = "http://localhost:8082" + "/api/products";
        String shippingServiceUrl   = "http://localhost:8081" + "/api/shipments";

        // Save newOrder in local DB
        Orders savedOrder = orderRepository.save(newOrder);

        // Check with Inventory-service
        try {
            inventoryResponse = restTemplate.postForObject(
                    inventoryServiceUrl, newOrder, Orders.class);

            System.out.println("inventoryResponse " + inventoryResponse.toString());
            System.out.println("inventoryResponse " + inventoryResponse.toString());

        }
        catch (Exception ex) {

            // If Inventory request was not successful, reset success flag
            System.out.println("Inventory approach failed " + ex);
            success = false; }

        // Check with Shipping-service
        try {
            shippingResponse = restTemplate.postForObject(
                    shippingServiceUrl, newOrder, Orders.class);

            System.out.println("shippingResponse " + shippingResponse.toString());
        }
        catch (Exception ex) {

            System.out.println("shippingFailure " + ex);

            // If Inventory request was not successful, reset success flag and inventory
            success = false;

            // Compose request
            HttpEntity<Orders> deleteRequest = new HttpEntity<>(newOrder);

            ResponseEntity<Orders> deleteResponse = restTemplate.exchange(
                    inventoryServiceUrl, HttpMethod.DELETE, deleteRequest, Orders.class);
        }

        if (success) {
            savedOrder.setOrderStatus(OrderStatus.SUCCESS);
            savedOrder.setShippingDate(shippingResponse.getShippingDate());
        } else {
            savedOrder.setOrderStatus(OrderStatus.FAILURE);
        }
        return orderRepository.save(savedOrder);


    }

    public Iterable<Orders> getOrders() {
        return orderRepository.findAll();
    }

    // Sub methods

}
