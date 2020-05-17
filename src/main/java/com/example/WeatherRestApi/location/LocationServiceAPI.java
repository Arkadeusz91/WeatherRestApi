package com.example.WeatherRestApi.location;

import java.util.List;

public interface LocationServiceAPI {
    List<Location> get();

    Location add(Location location);

    Location delete(Location location);

    Location update(long id, Location location);

    Location findById(long id);

    List<Location> findByCity(String name);

    List<Location> findByRegion(String name);

    List<Location> findByCountry(String name);

    List<Location> findByCoordinates(double longitude, double latitude);
}
