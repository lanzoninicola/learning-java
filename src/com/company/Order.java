package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {

    private final ICustomer customer;
    private int id;
    private LocalDateTime date = LocalDateTime.now();
    private String status = "idle";
    private ArrayList<OrderRow> orderRows = new ArrayList<OrderRow>();

    public Order(int id, ICustomer customer) {
        this.id = id;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ICustomer getCustomer() {
        return customer;
    }

    public void addProduct(Product prod, int qty) {
        OrderRow or = new OrderRow(this.id, prod, qty);

        this.orderRows.add(or);
    }

    public double getTotalValue() {

        double totalOrderValue = 0.0;

        for (OrderRow orderRow : orderRows) {
            Product prod = orderRow.getProduct();
            double unitPrice = prod.getUnitPrice();
            int qty = orderRow.getQuantity();

            double totalRowValue = qty * unitPrice;

            totalOrderValue += totalRowValue;

        }

        return totalOrderValue;
    }

    public void printOrderSummary() {

        String thankYouMessage = "Thank you! " + this.customer.getName() + " for your order done on " + this.date + ". Total Order is: " + this.getTotalValue();

        System.out.println(thankYouMessage);

    }


}
