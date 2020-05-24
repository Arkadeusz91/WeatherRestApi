package com.example.WeatherRestApi.weather;

import com.example.WeatherRestApi.location.Location;
import com.example.WeatherRestApi.location.LocationDbRepository;
import com.example.WeatherRestApi.weather.openWeatherApi.OpenWeatherApiExecutor;
import com.example.WeatherRestApi.weather.openWeatherApi.OpenWeatherApiResponse;
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
    private final OpenWeatherApiExecutor openWeatherApiExecutor;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository, LocationDbRepository locationRepository
            ,WeatherTransformer weatherTransformer,OpenWeatherApiExecutor openWeatherApiExecutor) {
        this.weatherRepository = weatherRepository;
        this.locationRepository = locationRepository;
        this.weatherTransformer = weatherTransformer;
        this.openWeatherApiExecutor = openWeatherApiExecutor;
    }

    @Override
    public List<WeatherDTO> getAll() {
        return weatherRepository.findAll().stream()
                .map((Weather weather)->weatherTransformer.toDTO(weather))
                .collect(Collectors.toList());
    }

    @Override
    public WeatherDTO add(WeatherDTO weather) {
        Weather weatherFromDb = weatherRepository.save(weatherTransformer.toEntity(weather));
        weatherFromDb.getLocation().getWeather().add(weatherFromDb);
        locationRepository.save(weatherFromDb.getLocation());
        return weatherTransformer.toDTO(weatherRepository.save(weatherFromDb));
    }

    @Override
    public WeatherDTO remove(String id) {
        weatherRepository.deleteById(id);
        return weatherTransformer.toDTO(weatherRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No entry with this ID")));
    }

    @Override
    public OpenWeatherApiResponse getOpenWeatherApiResponse(String locationName){
        return openWeatherApiExecutor.fetchWeather(locationName);
    }
}
