package com.handelsbanken.ecommerceapi.api.controller;

import com.handelsbanken.ecommerceapi.api.service.OrderService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ExceptionHandler({ NumberFormatException.class }) 
    @ResponseStatus(HttpStatus.BAD_REQUEST) 
    public Map<String, String> handleException(Exception ex) {
        Map<String, String> response = new HashMap<>();
        response.put("statusCode", HttpStatus.BAD_REQUEST.toString());
        response.put("error", "Wrong input format. Please provide a list of watch IDs as string.");
        return response;
    }

    @PostMapping("/checkout")
    public Map<String, Double> createOrder(@RequestBody List<String> watchIds) {
        double price = orderService.calculatePrice(watchIds);
        Map<String, Double> response = new HashMap<>();
        response.put("price", price);
        return response;
    }
}
