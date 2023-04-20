package dev.manyroads.Order.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto increment id
    private int addressID;
    private String name;
    private String house;
    private String street;
    private String city;
    private String zip;

    // Constructor

    public Address() {
    }

    public Address(String name, String house, String street, String city, String zip) {
        this.name = name;
        this.house = house;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    public Address(int addressID, String name, String house, String street, String city, String zip) {
        this.addressID = addressID;
        this.name = name;
        this.house = house;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    // Getters and Setters
    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressID=" + addressID +
                ", name='" + name + '\'' +
                ", house='" + house + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
