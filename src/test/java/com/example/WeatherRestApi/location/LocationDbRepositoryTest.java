package com.example.WeatherRestApi.location;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class LocationDbRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private LocationDbRepository repository;

    Location location1 = new Location();
    Location location2 = new Location();
    Location location3 = new Location();
    Location location4 = new Location();

    @BeforeAll
    static void init() {


    }

    @BeforeEach
    void setup() {
        location1 = new Location();
        location2 = new Location();
        location3 = new Location();
        location4 = new Location();
        location1.setCity("Szczecin");
        location1.setCountry("Poland");
        location1.setRegion("ZS");
        location1.setLongitude(10);
        location1.setLatitude(10);
        location2.setCity("Poznań");
        location2.setCountry("Poland");
        location2.setRegion("W");
        location2.setLongitude(20);
        location2.setLatitude(20);
        location3.setCity("Gryfino");
        location3.setCountry("Poland");
        location3.setRegion("ZS");
        location3.setLongitude(30);
        location3.setLatitude(30);
        location4.setCity("Berlin");
        location4.setCountry("Germany");
        location4.setRegion("-");
        location4.setLongitude(40);
        location4.setLatitude(40);
        entityManager.persist(location1);
        entityManager.persist(location2);
        entityManager.persist(location3);
        entityManager.persist(location4);
    }

    @Test
    void return_location_with_provided_city_using_findByCity() {
        List<Location> locationList = repository.findByCity("Szczecin");
        assertTrue(locationList.contains(location1));
        assertEquals(1, locationList.size());
    }

    @Test
    void return_location_with_provided_region_using_findByRegion() {
        List<Location> locationList = repository.findByRegion("ZS");
        assertTrue(locationList.contains(location1));
        assertTrue(locationList.contains(location3));
        assertEquals(2, locationList.size());
    }

    @Test
    void return_location_with_provided_country_using_findByCountry() {
        List<Location> locationList = repository.findByCountry("Poland");
        assertTrue(locationList.contains(location1));
        assertTrue(locationList.contains(location2));
        assertTrue(locationList.contains(location3));
        assertEquals(3, locationList.size());
    }

    @Test
    void return_location_with_provided_coordinated_using_findByLongitudeAndLatitude() {
        Location location = repository.findByLatitudeAndLongitude(20, 20).get();
        assertEquals(location2, location);
    }
}