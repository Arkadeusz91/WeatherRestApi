package com.example.WeatherRestApi.location;

import com.example.WeatherRestApi.weather.Weather;
import com.example.WeatherRestApi.weather.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class LocationTransformer {

    private final WeatherRepository weatherRepository;

    @Autowired
    public LocationTransformer(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public LocationDTO toDTO(Location location){
        LocationDTO locationDto = new LocationDTO();
        locationDto.setId(location.getId());
        locationDto.setLongitude(location.getLongitude());
        locationDto.setLatitude(location.getLatitude());
        locationDto.setCity(location.getCity());
        locationDto.setRegion(location.getRegion());
        locationDto.setCountry(location.getCountry());
        for (Weather weather:location.getWeather()) {
            locationDto.getWeatherId().add(weather.getId());
        }
        return locationDto;
    }

    public Location toEntity(LocationDTO locationDto){
        Location location = new Location();
        location.setId(locationDto.getId());
        location.setLongitude(locationDto.getLongitude());
        location.setLatitude(locationDto.getLatitude());
        location.setCity(locationDto.getCity());
        location.setRegion(locationDto.getRegion());
        location.setCountry(locationDto.getCountry());
        for (String id:locationDto.getWeatherId()) {
            Weather weather = weatherRepository.findById(id)
                    .orElseThrow(()->new NoSuchElementException("No entry with this ID"));
            location.getWeather().add(weather);
        }
        return location;
    }
}
