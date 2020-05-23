package com.example.WeatherRestApi.weather;

import com.example.WeatherRestApi.location.Location;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Entity
public class Weather {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Min(-274)
    private double temperature;
    private double pressure;
    private double humidity;
    @NotNull
    @Enumerated(EnumType.STRING)
    private WindDirection windDirection;
    private double windSpeed;
    @Pattern(regexp = "^([0]?[1-9]|[1|2][0-9]|[3][0|1])[./-]([0]?[1-9]|[1][0-2])[./-]([0-9]{4}|[0-9]{2})$")
    @NotNull
    @NotBlank
    private String date;

    @ManyToOne
    @NotNull
    private Location location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
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

    public WindDirection getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(WindDirection windDirection) {
        this.windDirection = windDirection;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return Double.compare(weather.temperature, temperature) == 0 &&
                Double.compare(weather.pressure, pressure) == 0 &&
                Double.compare(weather.humidity, humidity) == 0 &&
                Double.compare(weather.windSpeed, windSpeed) == 0 &&
                Objects.equals(id, weather.id) &&
                windDirection == weather.windDirection &&
                Objects.equals(date, weather.date) &&
                Objects.equals(location, weather.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, temperature, pressure, humidity, windDirection, windSpeed, date, location);
    }
}
