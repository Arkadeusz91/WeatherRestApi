package com.example.WeatherRestApi.weather;

import com.example.WeatherRestApi.location.Location;
import com.example.WeatherRestApi.location.LocationDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherTransformer {

    private final LocationDbRepository locationRepository;

    @Autowired
    public WeatherTransformer(LocationDbRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public WeatherDTO toDTO(Weather weather){
        WeatherDTO weatherDTO = new WeatherDTO();
        weatherDTO.setId(weather.getId());
        weatherDTO.setDate(weather.getDate());
        weatherDTO.setHumidity(weather.getHumidity());
        weatherDTO.setPressure(weather.getPressure());
        weatherDTO.setTemperature(weather.getTemperature());
        weatherDTO.setWindDirection(weather.getWindDirection());
        weatherDTO.setWindSpeed(weather.getWindSpeed());
        weatherDTO.setLocationId(weather.getLocation().getId());
        return weatherDTO;
    }

    public Weather toEntity(WeatherDTO weatherDTO){
        Weather weather = new Weather();
        weather.setId(weatherDTO.getId());
        weather.setDate(weatherDTO.getDate());
        weather.setHumidity(weatherDTO.getHumidity());
        weather.setPressure(weatherDTO.getPressure());
        weather.setTemperature(weatherDTO.getTemperature());
        weather.setWindDirection(weatherDTO.getWindDirection());
        weather.setWindSpeed(weatherDTO.getWindSpeed());
        locationRepository.findById(weatherDTO.getLocationId())
                .ifPresent((Location l) ->weather.setLocation(l));
        return weather;
    }
}
