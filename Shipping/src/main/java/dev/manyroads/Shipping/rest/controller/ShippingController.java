package dev.manyroads.Shipping.rest.controller;

import dev.manyroads.Shipping.domain.Orders;
import dev.manyroads.Shipping.domain.Shipment;
import dev.manyroads.Shipping.rest.repository.ShippingRepository;
import dev.manyroads.Shipping.rest.service.ShippingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/shipments")
public class ShippingController {

    // Attributes
    @Autowired
    ShippingService shippingService;

    @Autowired
    ShippingRepository shippingRepository;

    // Routes
    @PostMapping
    public Orders process(@RequestBody Orders order) {

        return shippingService.handleOrder(order);
    }

    @GetMapping("/allShippings")
    public List<Shipment> getAllShippings(){

        System.out.println("Route allShippings");
        System.out.println(shippingRepository.findAll());
        List<Shipment> l = (List<Shipment>) shippingRepository.findAll();
        return l;
    }
}
