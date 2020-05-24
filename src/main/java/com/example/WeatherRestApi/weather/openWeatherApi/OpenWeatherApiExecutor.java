package com.example.WeatherRestApi.weather.openWeatherApi;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenWeatherApiExecutor {

    private static final String OPEN_WEATHER_API_EXECUTOR = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=d2735b708921aa736fca7184b8cf170f&units=metric";

    public OpenWeatherApiResponse fetchWeather(String locationName) {
        RestTemplate restTemplate = new RestTemplate();
        String url =
                String.format(OPEN_WEATHER_API_EXECUTOR,locationName);
        OpenWeatherApiResponse response = restTemplate.getForObject(url,OpenWeatherApiResponse.class);
        return response;
    }
}
