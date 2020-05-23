package com.example.WeatherRestApi.weather;

import com.example.WeatherRestApi.location.Location;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.DateTimeException;

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
    @Pattern(regexp = "N|NW|NE|S|SW|SE|W|E")
    @NotNull
    @NotBlank
    private String windDirection;
    private double windSpeed;
    @Pattern(regexp = "^([0]?[1-9]|[1|2][0-9]|[3][0|1])[./-]([0]?[1-9]|[1][0-2])[./-]([0-9]{4}|[0-9]{2})$")
    @NotNull
    @NotBlank
    private String date;

    @ManyToOne
    private Location location;
}
