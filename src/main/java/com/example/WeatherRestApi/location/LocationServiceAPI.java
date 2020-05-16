package com.example.WeatherRestApi.location;

import java.util.List;
import java.util.UUID;

public interface LocationServiceAPI {
    List<Location> get();

    Location add(Location location);

    Location delete(Location location);

    Location update(UUID id, Location location);

    Location findById(UUID id);

    List<Location> findByCity(String name);

    List<Location> findByRegion(String name);

    List<Location> findByCountry(String name);

    List<Location> findByCoordinates(double longitude, double latitude);
}
