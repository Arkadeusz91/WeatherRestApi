package com.example.WeatherRestApi.location;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

public class LocationDTO {
    private String id;
    private double longitude;
    private double latitude;
    private String city;
    private String region;
    private String country;
    private List<String> weatherId = new ArrayList<>();

    public LocationDTO() {
    }

    public LocationDTO(String id, double longitude, double latitude, String city, String region, String country,
                       List<String> weatherId) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.city = city;
        this.region = region;
        this.country = country;
        this.weatherId = weatherId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(List<String> weatherId) {
        this.weatherId = weatherId;
    }
}
