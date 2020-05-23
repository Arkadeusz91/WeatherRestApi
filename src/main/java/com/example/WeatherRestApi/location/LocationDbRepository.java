package com.example.WeatherRestApi.location;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LocationDbRepository extends JpaRepository<Location, String> {
    List<Location> findByCity(String city);

    Optional<Location> findByLatitudeAndLongitude(double longitude, double latitude);

    List<Location> findByCountry(String country);

    List<Location> findByRegion(String region);

}
