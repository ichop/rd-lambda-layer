package com.rd.project.model;

import java.time.LocalDateTime;
import java.util.List;


public class Order {
    private Integer id;
    private Integer userId;
    private LocalDateTime orderDate;
    private String deliveryAddress;
    private List<OrderItem> orderItems;

    public Order(Integer userId, LocalDateTime orderDate, String deliveryAddress, List<OrderItem> orderItems) {
        this.userId = userId;
        this.orderDate = orderDate;
        this.deliveryAddress = deliveryAddress;
        this.orderItems = orderItems;
    }

    public Order(Integer id, Integer userId, LocalDateTime orderDate, String deliveryAddress, List<OrderItem> orderItems) {
        this.id = id;
        this.userId = userId;
        this.orderDate = orderDate;
        this.deliveryAddress = deliveryAddress;
        this.orderItems = orderItems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Order() {
    }
}
