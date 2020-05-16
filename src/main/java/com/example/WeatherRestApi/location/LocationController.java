package com.example.WeatherRestApi.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/location")
@RestController
public class LocationController {
    private final LocationService service;

    @Autowired
    public LocationController(LocationService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public List<Location> get(){
        return service.get();
    }

    @PostMapping("/add")
    public Location add(@Valid @RequestBody Location location){
        return service.add(location);
    }

    @PutMapping("/update/{id}")
    public Location update(@Valid @RequestBody Location location, @Valid @PathVariable("id")UUID id){
        return service.update(id,location);
    }

    @DeleteMapping("/delete")
    public Location delete(@Valid @RequestBody Location location){
        return service.delete(location);
    }
}
