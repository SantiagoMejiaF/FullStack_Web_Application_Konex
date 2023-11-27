package com.konex.app.application.useCases.CityUseCaseImpl;

import com.konex.app.domain.model.City;
import com.konex.app.domain.ports.in.CityUseCase.ReadCityUseCase;
import com.konex.app.domain.ports.out.CityRepositoryPort;
import java.util.List;
import java.util.Optional;

public class ReadCityUseCaseImpl implements ReadCityUseCase {

    private final CityRepositoryPort cityRepositoryPort;

    public ReadCityUseCaseImpl(CityRepositoryPort cityRepositoryPort) {
        this.cityRepositoryPort = cityRepositoryPort;
    }

    @Override
    public Optional<City> getCityById(Long id) {
        return cityRepositoryPort.findById(id);
    }

    @Override
    public List<City> getAllCities() {
        return cityRepositoryPort.findAll();
    }

    @Override
    public List<String> getAllCitiesNames() {
        return cityRepositoryPort.findAllCitiesNames();
    }

    @Override
    public Long getCityIdByName(String name) {
        return cityRepositoryPort.findCityIdByName(name);
    }
}