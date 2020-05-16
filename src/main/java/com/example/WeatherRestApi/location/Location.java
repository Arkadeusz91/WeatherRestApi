package com.example.WeatherRestApi.location;

import javax.validation.constraints.*;
import java.util.Objects;
import java.util.UUID;

public class Location {
    @Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$")
    private UUID id;
    @Min(-180)
    @Max(180)
    private double longitude;
    @Min(-90)
    @Max(90)
    private double latitude;
    @NotNull
    @NotBlank
    @NotEmpty
    private String city;
    private String region;
    @NotNull
    @NotBlank
    @NotEmpty
    private String country;

    public Location() {
    }

    public Location(UUID id, double longitude, double lattitude, String city, String region, String country) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = lattitude;
        this.city = city;
        this.region = region;
        this.country = country;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLattitude() {
        return latitude;
    }

    public void setLattitude(double lattitude) {
        this.latitude = lattitude;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Double.compare(location.longitude, longitude) == 0 &&
                Double.compare(location.latitude, latitude) == 0 &&
                Objects.equals(id, location.id) &&
                Objects.equals(city, location.city) &&
                Objects.equals(region, location.region) &&
                Objects.equals(country, location.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, longitude, latitude, city, region, country);
    }
}
