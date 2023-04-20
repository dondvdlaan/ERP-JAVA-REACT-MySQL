package dev.manyroads.Shipping.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Class Shipment indicates goods to be shipped with date and delivery address
 */
@Entity
public class Shipment {

    @Id
    // Auto increment id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int shipmentID;
    @Column(columnDefinition = "DATE")
    private LocalDate shippingDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressID")
    private Address address;

    // Constructors
    public Shipment() {
        this.shippingDate = LocalDate.now().minusDays(10);
        this.address = new Address() ;
    }

    public Shipment(LocalDate shippingDate, Address address) {
        this.shippingDate = shippingDate;
        this.address = address;
    }

    public int getShipmentID() {
        return shipmentID;
    }

    public void setShipmentID(int shipmentID) {
        this.shipmentID = shipmentID;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public Shipment setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Shipment setAddress(Address address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "shipmentID=" + shipmentID +
                ", shippingDate=" + shippingDate +
                ", address=" + address +
                '}';
    }
}
