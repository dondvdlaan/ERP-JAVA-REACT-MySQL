package dev.manyroads.Shipping.domain;

import dev.manyroads.Shipping.constants.OrderStatus;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;

import static jakarta.persistence.EnumType.STRING;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto increment id
    private int         orderID;
    private String      userId;
    private Long        total;
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
    }

    public Orders(String userId, Long total, String paymentMode, Address shippingAddress, LocalDate shippingDate, OrderStatus orderStatus, String responseMessage) {
        this.userId = userId;
        this.total = total;
        this.paymentMode = paymentMode;
        this.shippingAddress = shippingAddress;
        this.shippingDate = shippingDate;
        this.orderStatus = orderStatus;
        this.responseMessage = responseMessage;
    }

    // Getter and Setters

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public Orders setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }

    public Orders setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public Orders setResponseMessage(java.lang.String responseMessage) {
        this.responseMessage = responseMessage;
        return this;
    }


    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderID=" + orderID +
                ", userId='" + userId + '\'' +
                ", total=" + total +
                ", paymentMode='" + paymentMode + '\'' +
                ", shippingAddress=" + shippingAddress +
                ", shippingDate=" + shippingDate +
                ", orderStatus=" + orderStatus +
                ", responseMessage='" + responseMessage + '\'' +
                '}';
    }
}
