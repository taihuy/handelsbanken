package com.handelsbanken.ecommerceapi.unit.api.model;

import org.junit.jupiter.api.Test;

import com.handelsbanken.ecommerceapi.api.model.OrderLine;
import com.handelsbanken.ecommerceapi.api.model.Watch;
import com.handelsbanken.ecommerceapi.api.model.Watch.Discount;

import static org.junit.jupiter.api.Assertions.*;

public class OrderLineTest {

    @Test
    public void testCalculatePrice() {
        // Create a watch with a discount
        Watch watch = new Watch(1, "Watch 1", 80.0, new Discount(2, 120.0));

        // Create an order line with a quantity of 3
        OrderLine orderLine = new OrderLine(watch, 3);

        // Calculate the price
        double calculatedPrice = orderLine.calculatePrice();

        // Verify the expected price
        assertEquals(200.0, calculatedPrice);
    }
}