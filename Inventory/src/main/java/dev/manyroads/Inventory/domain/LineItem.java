package dev.manyroads.Inventory.domain;

/**
 * Class LineItem serves as an attribute of Class Order and is not stored in DB
 */
public class LineItem {

    // *** Constants ***
    private static final int DEF_VALUE_INT     = 0;
    private static final String DEF_VALUE_STR  = ">nothingToSeeHere<";

    // Attributes
    private int prodID;
    private int prodQuantity;

    // Constructor
    public LineItem() {
        this.prodID = DEF_VALUE_INT;
        this.prodQuantity = DEF_VALUE_INT;
    }

    // Setters and Getters

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
}
