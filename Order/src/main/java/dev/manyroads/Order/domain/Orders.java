package dev.manyroads.Order.domain;


import dev.manyroads.Order.constants.OrderStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;

/**
 * Class to capture all the attributes of an order
 */
@Entity
// Creates separate table for LineItems
@Inheritance(strategy = InheritanceType.JOINED)
public class Orders {

    // Constants
    private static final int DEF_VALUE_INT     = 0;
    private static final long DEF_VALUE_LONG   = 0;
    private static final String DEF_VALUE_STR  = ">nothingToSeeHere<";

    // Attributes
    @Id
    // Auto increment id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int         orderID;
    private String      userId;
    private Long        total;
    // Hibernate will save lineItems while saving parent
    @OneToMany(cascade = {CascadeType.ALL})
    private List<LineItem> lineItems;
    private String      paymentMode;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressID")
    private Address     shippingAddress;
    @Column(columnDefinition = "DATE")
    private LocalDate   shippingDate;
    @Enumerated(STRING)
    private OrderStatus orderStatus;
    private String      responseMessage;

    // Constructors
    public Orders() {
        this.userId             = DEF_VALUE_STR;
        this.total              = DEF_VALUE_LONG;
        this.lineItems          = new ArrayList<>();
        this.paymentMode        = DEF_VALUE_STR;
        this.shippingAddress    = new Address();
        this.shippingDate       = LocalDate.now().plusDays(-1);
        this.orderStatus        = orderStatus;
        this.responseMessage    = DEF_VALUE_STR;
    }

    public Orders(String userId, Long total, List<LineItem> lineItems, String paymentMode, Address shippingAddress, LocalDate shippingDate, OrderStatus orderStatus, String responseMessage) {
        this.userId = userId;
        this.total = total;
        this.lineItems = lineItems;
        this.paymentMode = paymentMode;
        this.shippingAddress = shippingAddress;
        this.shippingDate = shippingDate;
        this.orderStatus = orderStatus;
        this.responseMessage = responseMessage;
    }
// Getter and Setters

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderID=" + orderID +
                ", userId='" + userId + '\'' +
                ", total=" + total +
                ", lineItems=" + lineItems +
                ", paymentMode='" + paymentMode + '\'' +
                ", shippingAddress=" + shippingAddress +
                ", shippingDate=" + shippingDate +
                ", orderStatus=" + orderStatus +
                ", responseMessage='" + responseMessage + '\'' +
                '}';
    }
}
