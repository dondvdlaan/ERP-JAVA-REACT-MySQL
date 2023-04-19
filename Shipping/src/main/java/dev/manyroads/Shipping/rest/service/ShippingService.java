package dev.manyroads.Shipping.rest.service;

import dev.manyroads.Shipping.constants.OrderStatus;
import dev.manyroads.Shipping.domain.Orders;
import dev.manyroads.Shipping.domain.Shipment;
import dev.manyroads.Shipping.rest.repository.ShippingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class ShippingService {

    @Autowired
    ShippingRepository shippingRepository;

    // ---- Methods ----
    public Orders handleOrder(Orders order) {

        // ---- Attributes ----
        LocalDate shippingDate = LocalDate.now().minusDays(1);
        Shipment saveShipment = shippingRepository.save(new Shipment());

        // Check office hours and Set shipping date
        if (officeHours())
                    shippingDate = LocalDate.now().plusDays(1);
        else
                    throw new RuntimeException("It is outside office hours to place order.");

        // Compose and store Shipment
        saveShipment.setAddress(order.getShippingAddress());
        saveShipment.setShippingDate(shippingDate);
        shippingRepository.save(saveShipment);

        // (this way of coding made possible through Getters/setters w this)
        return order
                .setShippingDate(shippingDate)
                .setOrderStatus(OrderStatus.SUCCESS);
    }

    // Sub methods
    Boolean officeHours(){

        return (LocalTime.now().isAfter(LocalTime.parse("10:00")) &&
                LocalTime.now().isBefore(LocalTime.parse("23:00")));
    }
}
