package com.example.WeatherRestApi.weather;

import com.example.WeatherRestApi.location.Location;
import com.example.WeatherRestApi.location.LocationDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class WeatherService implements WeatherServiceAPI {

    private final WeatherRepository weatherRepository;
    private final LocationDbRepository locationRepository;
    private final WeatherTransformer weatherTransformer;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository, LocationDbRepository locationRepository,WeatherTransformer weatherTransformer) {
        this.weatherRepository = weatherRepository;
        this.locationRepository = locationRepository;
        this.weatherTransformer = weatherTransformer;
    }

    @Override
    public List<WeatherDTO> getAll() {
        return weatherRepository.findAll().stream()
                .map((Weather weather)->weatherTransformer.toDTO(weather))
                .collect(Collectors.toList());
    }

    @Override
    public WeatherDTO add(WeatherDTO weather) {
        Location location = locationRepository.findById(weather.getLocationId())
                .orElseThrow(()->new NoSuchElementException("No entry with this ID"));
        Weather weatherFromDb = weatherRepository.save(weatherTransformer.toEntity(weather));
        location.getWeather().add(weatherFromDb);
        locationRepository.save(location);
        return weatherTransformer.toDTO(weatherRepository.save(weatherFromDb));
    }

    @Override
    public WeatherDTO remove(String id) {
        weatherRepository.deleteById(id);
        return weatherTransformer.toDTO(weatherRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No entry with this ID")));
    }
}
