package com.konex.app.domain.ports.in.CityUseCase;

import com.konex.app.domain.model.City;
import java.util.List;

public interface CreateCityUseCase {

    City createCity(City city);
    List<City> createCities(List<City> cities);
}