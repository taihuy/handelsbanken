package com.handelsbanken.ecommerceapi.api.model;

public class Watch {
    private int id;
    private String name;
    private double unitPrice;
    private Discount discount; 

    public Watch(int id, String name, double unitPrice, Discount d) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.discount = d;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(int quantity, double price) {
        this.discount = new Discount(quantity, price);
    }

    public boolean hasNoDiscount() {
        return this.getDiscount() == null;
    }

    public record Discount(int quantity, double price) {
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    };

}
