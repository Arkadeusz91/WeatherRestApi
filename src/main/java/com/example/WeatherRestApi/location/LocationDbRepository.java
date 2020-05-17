package com.example.WeatherRestApi.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LocationDbRepository extends JpaRepository<Location,Long> {

}
