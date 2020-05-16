package com.example.WeatherRestApi.location;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Repository
public class ListLocationRepository implements LocationRepository{
    List<Location> locationList = new ArrayList<>();

    @Override
    public Location add(Location location) {
        if(locationList.contains(location)){
            throw new IllegalArgumentException("Location already exists!");
        }
        locationList.add(location);
        return location;
    }

    @Override
    public List<Location> getAll() {
        return locationList;
    }

    @Override
    public Location delete(Location location) {
        if (locationList.contains(location)) {
            locationList.remove(location);
            return location;
        }else {
            throw new NoSuchElementException("Nothing to delete");
        }
    }

    @Override
    public Location update(UUID toUpdate, Location updatedData) {
        for (Location location:locationList){
            if(location.getId().equals(toUpdate)){
                locationList.add(locationList.indexOf(location),updatedData);
                return updatedData;
            }
        }
        throw new NoSuchElementException("No location with such ID");
    }
}
