package dev.manyroads.Order.rest.controller;

import dev.manyroads.Order.constants.OrderStatus;
import dev.manyroads.Order.domain.Orders;
import dev.manyroads.Order.rest.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(("/api/orders"))
public class OrderController {

    // Attributes
    @Autowired
    OrderService orderService;

    // Routes
    @PostMapping
    public Orders create(@RequestBody Orders newOrder) {

        // Process order
        Orders processedOrder = orderService.createOrder(newOrder);

        if (OrderStatus.FAILURE.equals(processedOrder.getOrderStatus())) {
            throw new RuntimeException("Order processing failed, please try again later.");
        }
        return processedOrder;
    }

    @GetMapping
    public Iterable<Orders> getAll() {

        System.out.println("Route: getAll ");
        return orderService.getOrders();
    }}
