package com.konex.app.domain.ports.in.CityUseCase;

import com.konex.app.domain.model.City;
import java.util.List;
import java.util.Optional;

public interface ReadCityUseCase {

    Optional<City> getCityById(Long id);
    List<City> getAllCities();
    List<String> getAllCitiesNames();
    Long getCityIdByName(String name);
}