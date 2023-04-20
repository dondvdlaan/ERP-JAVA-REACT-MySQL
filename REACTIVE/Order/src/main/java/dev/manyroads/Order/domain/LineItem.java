package dev.manyroads.Order.domain;

import jakarta.persistence.Entity;

/**
 * Class to extend Orders with product data
 */
@Entity
public class LineItem extends Orders {

    // Attributes
    private int 	prodID;
    private int 	prodQuantity;

    // Getters and Setters
    public int getProdID() {
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    public int getProdQuantity() {
        return prodQuantity;
    }

    public void setProdQuantity(int prodQuantity) {
        this.prodQuantity = prodQuantity;
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "prodID=" + prodID +
                ", prodQuantity=" + prodQuantity +
                '}';
    }
}
