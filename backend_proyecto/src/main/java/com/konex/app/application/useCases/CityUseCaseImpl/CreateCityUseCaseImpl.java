package com.konex.app.application.useCases.CityUseCaseImpl;

import com.konex.app.domain.model.City;
import com.konex.app.domain.ports.in.CityUseCase.CreateCityUseCase;
import com.konex.app.domain.ports.out.CityRepositoryPort;

import java.util.List;

public class CreateCityUseCaseImpl implements CreateCityUseCase {

    private final CityRepositoryPort cityRepositoryPort;

    public CreateCityUseCaseImpl(CityRepositoryPort cityRepositoryPort) {
        this.cityRepositoryPort = cityRepositoryPort;
    }

    @Override
    public City createCity(City city) {
        return cityRepositoryPort.save(city);
    }


    @Override
    public List<City> createCities(List<City> cities) {
        return cityRepositoryPort.saveAll(cities);
    }
}