package com.example.WeatherRestApi.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LocationService implements LocationServiceAPI {

    private final LocationDbRepository locationRepository;

    @Autowired
    public LocationService(LocationDbRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> get() {
        return locationRepository.findAll();
    }

    @Override
    public Location findById(String id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No element with this ID"));
    }


    @Override
    public Location add(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location delete(Location location) {
        locationRepository.delete(location);
        return location;
    }

    @Override
    public Location update(String id, Location location) {
        if (locationRepository.existsById(id)) {
            location.setId(id);
            Location toUpdate = locationRepository.getOne(id);
            toUpdate = location;
            locationRepository.save(toUpdate);
            return toUpdate;
        }
        throw new NoSuchElementException("Location not in database");
    }

    @Override
    public List<Location> findBy(Map<String, String> params) {
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
        return result;
    }
}
