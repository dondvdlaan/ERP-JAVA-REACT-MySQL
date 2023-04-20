package dev.manyroads.Inventory.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Class Product is held in DB to record product attributes and especially the stock level
 */
@Entity
public class Product {

    // *** Constants ***
    private static final long DEF_VALUE_LONG    = 0;
    private static final Integer DEF_VALUE_INT  = 0;
    private static final String DEF_VALUE_STR   = ">nothingToSeeHere<";

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment id
    private int     prodID;
    private String  prodName;
    private Long    prodPrice;
    private Integer prodStock;

    // Constructor
    public Product(){
        this.prodName   = DEF_VALUE_STR;
        this.prodPrice  = DEF_VALUE_LONG;
        this.prodStock  = DEF_VALUE_INT;
    }

    public Product(String prodName, Long prodPrice, Integer prodStock) {
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.prodStock = prodStock;
    }
    // Getters & Setters

    public int getProdID() {
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Long getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(Long prodPrice) {
        this.prodPrice = prodPrice;
    }

    public void setProdStock(Integer prodStock) {
        this.prodStock = prodStock;
    }

    public Integer getProdStock() {
        return prodStock;
    }

    // ToPrint
    @Override
    public String toString() {
        return "Product{" +
                "prodID=" + prodID +
                ", prodName='" + prodName + '\'' +
                ", prodPrice=" + prodPrice +
                ", prodStock=" + prodStock +
                '}';
    }
}
