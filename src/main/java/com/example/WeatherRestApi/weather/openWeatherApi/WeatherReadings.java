package com.example.WeatherRestApi.weather.openWeatherApi;

public class WeatherReadings {
    double temp;
    double pressure;
    double humidity;

    public WeatherReadings() {
    }

    public WeatherReadings(double temp, double pressure, double humidity) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
}
