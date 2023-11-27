package com.konex.app.infrastructure.controllers;

import com.konex.app.application.services.CityService;
import com.konex.app.domain.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = cityService.getAllCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> getAllCitiesNames() {
        List<String> citiesNames = cityService.getAllCitiesNames();
        return new ResponseEntity<>(citiesNames, HttpStatus.OK);
    }

    @GetMapping("/id-by-name/{name}")
    public ResponseEntity<Long> getCityIdByName(@PathVariable String name) {
        Long cityIdByName = cityService.getCityIdByName(name);
        return new ResponseEntity<>(cityIdByName, HttpStatus.OK);
    }
}