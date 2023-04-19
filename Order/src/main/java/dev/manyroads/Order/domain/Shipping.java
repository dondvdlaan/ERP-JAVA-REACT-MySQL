package dev.manyroads.Order.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto increment id
    private int shipmentID;
    private LocalDate shippingDate;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "addressID")
    private Address address;

    // Constructors
    public Shipping() {
    }

    public Shipping(LocalDate shippingDate, Address address) {
        this.shippingDate = shippingDate;
        this.address = address;
    }

    public Shipping setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }

    public Shipping setAddress(Address address) {
        this.address = address;
        return this;
    }

}
