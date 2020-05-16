package com.example.WeatherRestApi.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LocationService implements LocationServiceAPI {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> get() {
        return locationRepository.getAll();
    }

    @Override
    public Location findById(UUID id) {
        return locationRepository.getAll().stream()
                .filter((Location l) -> l.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("No location with this ID"));
    }

    @Override
    public List<Location> findByCity(String name) {
        return locationRepository.getAll().stream()
                .filter((Location l) -> l.getCity().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Location> findByRegion(String name) {
        return locationRepository.getAll().stream()
                .filter((Location l) -> l.getRegion().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Location> findByCountry(String name) {
        return locationRepository.getAll().stream()
                .filter((Location l) -> l.getCountry().equals(name))
                .collect(Collectors.toList());
    }


    @Override
    public Location add(Location location) {
        return locationRepository.add(location);
    }

    @Override
    public Location delete(Location location) {
        return locationRepository.delete(location);
    }

    @Override
    public Location update(UUID id, Location location) {
        return locationRepository.update(id, location);
    }

    @Override
    public List<Location> findByCoordinates(double longitude, double latitude) {
        return locationRepository.getAll().stream()
                .filter((Location l) -> l.getLongitude() == longitude)
                .filter((Location l) -> l.getLattitude() == latitude)
                .collect(Collectors.toList());
    }
}
