package com.example.WeatherRestApi.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherServiceAPI service;

    @Autowired
    public WeatherController(WeatherServiceAPI service) {
        this.service = service;
    }

    @GetMapping
    public List<WeatherDTO> getAll(){
        return service.getAll();
    }

    @PostMapping()
    public WeatherDTO add(@Valid @RequestBody WeatherDTO weather){
        return service.add(weather);
    }

    @DeleteMapping("/{id}")
    public WeatherDTO remove(@PathVariable String id){
        return service.remove(id);
    }
}
