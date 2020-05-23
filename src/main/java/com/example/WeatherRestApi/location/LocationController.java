package com.example.WeatherRestApi.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequestMapping("/location")
@RestController
public class LocationController {
    private final LocationServiceAPI service;

    @Autowired
    public LocationController(LocationServiceAPI service) {
        this.service = service;
    }

    @GetMapping("/get")
    public List<LocationDTO> get() {
        return service.get();
    }

    @PostMapping("/add")
    public LocationDTO add(@Valid @RequestBody LocationDTO location) {
        return service.add(location);
    }

    @PutMapping("/update/{id}")
    public LocationDTO update(@Valid @RequestBody LocationDTO location, @Valid @PathVariable("id") String id) {
        return service.update(id, location);
    }

    @DeleteMapping("/delete/{id}")
    public LocationDTO delete(@Valid @PathVariable String id) {
        return service.delete(id);
    }

    @GetMapping("/find")
    public List<LocationDTO> findBy(@RequestParam Map<String,String> params){
        return service.findBy(params);
    }
}
