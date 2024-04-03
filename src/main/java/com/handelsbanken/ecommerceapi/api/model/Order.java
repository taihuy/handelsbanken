package com.handelsbanken.ecommerceapi.api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.handelsbanken.ecommerceapi.api.dao.WatchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Order {
    private List<OrderLine> orderLines;
    private double price;
    private Logger log = LoggerFactory.getLogger(Order.class);

    public double getPrice() {
        return price;
    }

    public Order() {
        this.orderLines = new ArrayList<>();
    }

    public Order(List<String> watchIds, WatchRepository watchRepository) {
        this.orderLines = new ArrayList<>();
        for (String watchId : watchIds) {
            Watch watch = watchRepository.getWatchById(Integer.parseInt(watchId));
            if (watch != null) {
                addWatches(watch, 1);
            } else {
                log.warn("Watch with id " + watchId + " not found in the database!");
            }
        }
        this.price = calculatePrice();
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void addWatches(Watch watch, int quantity) {
        Optional<OrderLine> lineToUpdate = orderLines.stream()
                .filter(orderLine -> orderLine.getWatch().getId() == watch.getId())
                .findFirst();
        lineToUpdate.ifPresent(orderLine -> {
            orderLine.increaseQuantity(quantity);
            orderLine.calculatePrice();
            calculatePrice();
        });

        if (lineToUpdate.isEmpty()) {
            OrderLine newOrderLine = new OrderLine(watch, quantity);
            this.orderLines.add(newOrderLine);
            calculatePrice();
        }
    }

    public double calculatePrice() {
        double price = 0;
        for (OrderLine orderLine : orderLines) {
            price += orderLine.getPrice();
        }
        this.price = price;
        return price;
    }

}
