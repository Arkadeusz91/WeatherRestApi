package com.example.WeatherRestApi.location;

import java.util.List;
import java.util.Map;

public interface LocationServiceAPI {
    List<Location> get();

    Location add(Location location);

    Location delete(Location location);

    Location update(String id, Location location);

    Location findById(String id);

    List<Location> findBy(Map<String, String> params);
}
