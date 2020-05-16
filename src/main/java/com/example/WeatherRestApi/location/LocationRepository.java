package com.example.WeatherRestApi.location;

import java.util.List;
import java.util.UUID;

public interface LocationRepository {
    Location add(Location location);

    List<Location> getAll();

    Location delete(Location location);

    Location update(UUID toUpdate, Location updatedData);
}
