package com.example.WeatherRestApi.location;

import java.util.List;
import java.util.Map;

public interface LocationServiceAPI {
    List<LocationDTO> get();

    LocationDTO add(LocationDTO location);

    LocationDTO delete(String id);

    LocationDTO update(String id, LocationDTO location);

    LocationDTO findById(String id);

    List<LocationDTO> findBy(Map<String, String> params);
}
