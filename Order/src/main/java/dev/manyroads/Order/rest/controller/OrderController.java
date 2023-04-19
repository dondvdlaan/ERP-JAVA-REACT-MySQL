package dev.manyroads.Order.rest.controller;

import dev.manyroads.Order.constants.OrderStatus;
import dev.manyroads.Order.domain.Orders;
import dev.manyroads.Order.rest.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
//@CrossOrigin(origins = "*")
@RequestMapping(("/api/orders"))
public class OrderController {

    // Attributes
    @Autowired
    OrderService orderService;

    // Routes
    @PostMapping
    public Orders create(@RequestBody Orders newOrder) {



        System.out.println("userID: " + newOrder.getUserId().toString());
        System.out.println("total: " + newOrder.getTotal().toString());
        newOrder.getLineItems().forEach(i-> System.out.println("item: " + i.toString()));
        System.out.println("Payment: " + newOrder.getPaymentMode().toString());
        System.out.println("Address: " + newOrder.getShippingAddress().toString());
        System.out.println("Date: " + newOrder.getShippingDate().toString());
        System.out.println("Status: " + newOrder.getOrderStatus().toString());

        // Process order
        Orders processedOrder = orderService.createOrder(newOrder);
        /*

        if (OrderStatus.FAILURE.equals(processedOrder.getOrderStatus())) {
            throw new RuntimeException("Order processing failed, please try again later.");
        }
 */
        return newOrder;
        //return processedOrder;
    }

    @GetMapping
    public Iterable<Orders> getAll() {

        System.out.println("Route: getAll ");
        return orderService.getOrders();
    }}
