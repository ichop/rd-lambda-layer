package com.rd.project.model;

public class OrderItem {
    private Integer orderId;
    private Integer itemId;
    private Integer itemAmount;

    public OrderItem() {
    }

    public OrderItem(Integer itemId, Integer itemAmount) {
        this.itemId = itemId;
        this.itemAmount = itemAmount;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(Integer itemAmount) {
        this.itemAmount = itemAmount;
    }
}