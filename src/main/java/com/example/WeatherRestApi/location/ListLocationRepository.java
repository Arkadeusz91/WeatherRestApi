package com.example.WeatherRestApi.location;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Repository
public class ListLocationRepository implements LocationRepository {
    private final List<Location> locationList = new ArrayList<>();

    @Override
    public Location add(Location location) {
        locationList.add(locationList.stream()
                .filter((Location l) -> l.equals(location))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Location already exists")));
        return location;
    }

    @Override
    public List<Location> getAll() {
        return locationList;
    }

    @Override
    public Location delete(Location location) {
        locationList.remove(locationList.stream()
                .filter((Location l) -> l.equals(location))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Nothing to delete")));
        return location;
    }

    @Override
    public Location update(long toUpdate, Location updatedData) {
        Location item = locationList.stream()
                .filter((Location l) -> l.getId()==toUpdate)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Location do not exist"));
        locationList.add(item);
        return item;
    }
}
