package com.handelsbanken.ecommerceapi.api.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.handelsbanken.ecommerceapi.api.model.Watch;

@Repository
public class WatchRepository {
    private List<Watch> watches = new ArrayList<>();

    public WatchRepository() {
        // Add some static data
        watches.add(new Watch(1, "Rolex", 100, new Watch.Discount(3, 200)));
        watches.add(new Watch(2, "Michael Kors", 80, new Watch.Discount(2, 120)));
        watches.add(new Watch(3, "Swatch", 50, null));
        watches.add(new Watch(4, "Casio", 30, null));
    }

    public List<Watch> getAllWatches() {
        return watches;
    }

    public Watch getWatchById(int id) {
        return watches.stream()
                .filter(watch -> watch.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addWatch(Watch watch) {
        watches.add(watch);
    }

    public void updateWatch(int id, Watch updatedWatch) {
        Watch watchToUpdate = getWatchById(id);
        if (watchToUpdate != null) {
            watchToUpdate.setName(updatedWatch.getName());
            watchToUpdate.setUnitPrice(updatedWatch.getUnitPrice());
            watchToUpdate.setDiscount(updatedWatch.getDiscount());
        }
    }

    public void deleteWatch(int id) {
        watches.removeIf(watch -> watch.getId() == id);
    }
}
