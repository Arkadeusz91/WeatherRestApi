package com.example.WeatherRestApi.weather;

import com.example.WeatherRestApi.weather.openWeatherApi.OpenWeatherApiResponse;

import java.util.List;

public interface WeatherServiceAPI {
    List<WeatherDTO> getAll();

    WeatherDTO add(WeatherDTO weather);

    WeatherDTO remove(String id);

    OpenWeatherApiResponse getOpenWeatherApiResponse(String locationName);
}
