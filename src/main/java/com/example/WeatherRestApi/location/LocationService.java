package com.example.WeatherRestApi.location;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@RequestMapping("/location")
@RestController
public class LocationService {
    LocationRepository repository;

    @PostMapping("/add")
    public Location add(@RequestBody Location location) {
        return repository.add(location);
    }

    @GetMapping("/get")
    public List<Location> getAll() {
        return repository.getAll();
    }

    @DeleteMapping("/delete")
    public Location delete(@RequestBody Location location) {
        return repository.delete(location);
    }

    @PutMapping("/update")
    public Location update(UUID id, Location location) {
        return repository.update(id, location);
    }

    @GetMapping("/get/{city}")
    public List<Location> getByCity(@PathVariable String city) {
        return repository.getAll().stream()
                .filter(location -> location.getCity().equals(city))
                .collect(Collectors.toList());
    }

    @GetMapping("/get/{id}")
    public Location getById(@PathVariable UUID id) {
        return repository.getAll().stream()
                .filter(location -> location.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException());
    }

    @GetMapping("get/{longi}&{lat}")
    public Location getByCoordinates(@PathVariable long longi, @PathVariable long lat) {
        return repository.getAll().stream()
                .filter(location -> location.getLongitude() == longi)
                .filter(location -> location.getLattitude() == lat)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException());
    }
}
