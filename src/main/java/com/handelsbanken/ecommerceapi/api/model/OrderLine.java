package com.handelsbanken.ecommerceapi.api.model;

public class OrderLine {
    private Watch watch;
    private int quantity;
    private double price;

    public OrderLine(Watch watch, int quantity) {
        this.watch = watch;
        this.quantity = quantity;
        calculatePrice();
    }

    public Watch getWatch() {
        return watch;
    }

    public void setWatch(Watch watch) {
        this.watch = watch;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        calculatePrice();
    }

    public void increaseQuantity(int count) {
        this.quantity += count;
        calculatePrice();
    }

    public double getPrice() {
        return price;
    }

    // generate method to calculate price
    public double calculatePrice() {
        try {
            if (watch == null)
                throw new NullPointerException("Watch is null");
            if (watch.hasNoDiscount() || this.quantity < watch.getDiscount().quantity())
                this.price = watch.getUnitPrice() * this.quantity;
            else {
                int discountedQuantity = this.quantity / watch.getDiscount().quantity();
                int remainingQuantity = this.quantity % watch.getDiscount().quantity();
                this.price = discountedQuantity * watch.getDiscount().price()
                        + remainingQuantity * watch.getUnitPrice();
            }
            return this.price;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return -1;
        }

    }
}
