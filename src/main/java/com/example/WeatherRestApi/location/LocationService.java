package com.example.WeatherRestApi.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LocationService implements LocationServiceAPI {

    private final LocationDbRepository locationRepository;
    private final LocationTransformer locationTransformer;

    @Autowired
    public LocationService(LocationDbRepository locationRepository,LocationTransformer locationTransformer) {
        this.locationRepository = locationRepository;
        this.locationTransformer = locationTransformer;
    }

    @Override
    public List<LocationDTO> get() {
        return locationRepository.findAll().stream()
                .map((Location l)->locationTransformer.toDTO(l))
                .collect(Collectors.toList());
    }

    @Override
    public LocationDTO findById(String id) {
        return locationTransformer.toDTO(locationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No element with this ID")));
    }


    @Override
    public LocationDTO add(LocationDTO location) {
        return locationTransformer.toDTO(locationRepository.save(locationTransformer.toEntity(location)));
    }

    @Override
    public LocationDTO delete(String id) {
        Location toDelete = locationRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("No entry with this ID"));
        locationRepository.delete(toDelete);
        return locationTransformer.toDTO(toDelete);
    }

    @Override
    public LocationDTO update(String id, LocationDTO location) {
        if (locationRepository.existsById(id)) {
            location.setId(id);
            Location toUpdate = locationTransformer.toEntity(location);
            Location updated = locationRepository.save(toUpdate);
            return locationTransformer.toDTO(updated);
        }
        throw new NoSuchElementException("Location not in database");
    }

    @Override
    public List<LocationDTO> findBy(Map<String, String> params) {
        Set<Location> resultSet = new HashSet<>();
        if (params.containsKey("id")) {
            locationRepository.findById(params.get("id"))
                    .ifPresent(l -> resultSet.add(l));
        }

        if (params.containsKey("city")) {
            resultSet.addAll(locationRepository.findByCity(params.get("city")));
        }
        if (params.containsKey("region")) {
            resultSet.addAll(locationRepository.findByRegion(params.get("region")));
        }
        if (params.containsKey("country")) {
            resultSet.addAll(locationRepository.findByCountry(params.get("country")));
        }
        if (params.containsKey("longitude") && params.containsKey("latitude")) {
            resultSet.add(locationRepository
                    .findByLatitudeAndLongitude(Double.parseDouble(params.get("latitude"))
                            , Double.parseDouble(params.get("longitude")))
                    .get());
        }
        List<Location> result = new ArrayList<>(resultSet);
        return result.stream()
                .map((Location l)->locationTransformer.toDTO(l))
                .collect(Collectors.toList());
    }
}
