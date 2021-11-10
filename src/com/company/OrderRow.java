package com.company;

public class OrderRow {

    private int orderId;
    private Product product;
    private int quantity;


    public OrderRow(int orderId, Product product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

}
