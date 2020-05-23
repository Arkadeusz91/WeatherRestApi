package com.example.WeatherRestApi.weather;

import java.util.List;

public interface WeatherServiceAPI {
    public List<WeatherDTO> getAll();
    public WeatherDTO add(WeatherDTO weather);
    public WeatherDTO remove(String id);
}
