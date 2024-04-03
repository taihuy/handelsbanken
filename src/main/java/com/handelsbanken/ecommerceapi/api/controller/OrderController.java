package com.handelsbanken.ecommerceapi.api.controller;

import com.handelsbanken.ecommerceapi.api.service.OrderService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    
    @PostMapping("/order")
    public Map<String, Double> createOrder(@RequestBody List<String> watchIds) {
        double price = orderService.calculatePrice(watchIds);
        Map<String, Double> response = new HashMap<>();
        response.put("price", price);
        return response;
    }
}
