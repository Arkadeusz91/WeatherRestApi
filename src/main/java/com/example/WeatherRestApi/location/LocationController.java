package com.example.WeatherRestApi.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequestMapping("/location")
@RestController
public class LocationController {
    private final LocationServiceAPI service;

    @Autowired
    public LocationController(LocationServiceAPI service) {
        this.service = service;
    }

    @GetMapping("/get")
    public List<Location> get() {
        return service.get();
    }

    @PostMapping("/add")
    public Location add(@Valid @RequestBody Location location) {
        return service.add(location);
    }

    @PutMapping("/update/{id}")
    public Location update(@Valid @RequestBody Location location, @Valid @PathVariable("id") String id) {
        return service.update(id, location);
    }

    @DeleteMapping("/delete")
    public Location delete(@Valid @RequestBody Location location) {
        return service.delete(location);
    }

    @GetMapping("/find")
    public List<Location> findBy(@RequestParam Map<String,String> params){
        return service.findBy(params);
    }
}
