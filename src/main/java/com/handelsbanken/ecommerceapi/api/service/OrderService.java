package com.handelsbanken.ecommerceapi.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.handelsbanken.ecommerceapi.api.dao.WatchRepository;
import com.handelsbanken.ecommerceapi.api.model.Order;

@Service
public class OrderService {

    private WatchRepository watchRepository;

    public OrderService(WatchRepository watchRepository) {
        this.watchRepository = watchRepository;
    }

    public double calculatePrice(List<String> watchIds) {
        Order order = new Order(watchIds, watchRepository);
        return order.calculatePrice();
    }

}
