package dev.manyroads.Inventory.domain;

import dev.manyroads.Inventory.constants.OrderStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Order serves a DTO between Order-service and Inventory-service. Class Order is not stored in inventory DB.
 */
public class Orders {

    // *** Constants ***
    private static final int DEF_VALUE_INT     = 0;
    private static final long DEF_VALUE_LONG   = 0;
    private static final String DEF_VALUE_STR  = ">nothingToSeeHere<";

    // Attributes
    private int             orderID;
    private String          userId;
    private List<LineItem>  lineItems;
    private Long            total;
    private OrderStatus orderStatus;
    private String          responseMessage;

    // Constructor
    public Orders() {
        this.orderID            = DEF_VALUE_INT;
        this.userId             = DEF_VALUE_STR;
        this.lineItems          = new ArrayList<LineItem>();
        this.total              = DEF_VALUE_LONG;
        this.orderStatus        = orderStatus;
        this.responseMessage    = DEF_VALUE_STR;
    }

    public Orders(List<LineItem> lineItems, Long total, OrderStatus orderStatus, String responseMessage) {
        this.lineItems = lineItems;
        this.total = total;
        this.orderStatus = orderStatus;
        this.responseMessage = responseMessage;
    }

    // Getters & Setters
    public Orders setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public Orders setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
        return this;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }
}
