package com.konex.app.application.services;

import com.konex.app.domain.model.City;
import com.konex.app.domain.ports.in.CityUseCase.CreateCityUseCase;
import com.konex.app.domain.ports.in.CityUseCase.ReadCityUseCase;
import com.konex.app.domain.ports.in.CityUseCase.UpdateCityUseCase;
import java.util.List;
import java.util.Optional;

public class CityService implements CreateCityUseCase, ReadCityUseCase, UpdateCityUseCase {

    private final CreateCityUseCase createCityUseCase;
    private final UpdateCityUseCase updateCityUseCase;
    private final ReadCityUseCase readCityUseCase;

    public CityService(CreateCityUseCase createCityUseCase, ReadCityUseCase readCityUseCase,
                       UpdateCityUseCase updateCityUseCase) {
        this.createCityUseCase = createCityUseCase;
        this.updateCityUseCase = updateCityUseCase;
        this.readCityUseCase = readCityUseCase;
    }

    @Override
    public City createCity(City city) {
        return createCityUseCase.createCity(city);
    }

    @Override
    public List<City> createCities(List<City> cities) {
        return createCityUseCase.createCities(cities);
    }

    @Override
    public Optional<City> updateCity(Long id, City city) {
        return updateCityUseCase.updateCity(id, city);
    }


    @Override
    public Optional<City> getCityById(Long id) {
        return readCityUseCase.getCityById(id);
    }

    @Override
    public List<City> getAllCities() {
        return readCityUseCase.getAllCities();
    }
}