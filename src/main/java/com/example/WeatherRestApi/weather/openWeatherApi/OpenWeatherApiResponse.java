package com.example.WeatherRestApi.weather.openWeatherApi;

public class OpenWeatherApiResponse {
    WeatherReadings main;
    Wind wind;
    Coordinates coord;
    String name;

    public OpenWeatherApiResponse(WeatherReadings main, Wind wind, Coordinates coord,String name) {
        this.main = main;
        this.wind = wind;
        this.coord = coord;
        this.name = name;
    }

    public OpenWeatherApiResponse() {
    }

    public WeatherReadings getMain() {
        return main;
    }

    public void setMain(WeatherReadings main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
