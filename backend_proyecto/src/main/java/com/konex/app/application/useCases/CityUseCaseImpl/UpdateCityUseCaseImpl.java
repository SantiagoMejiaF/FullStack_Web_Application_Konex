package com.konex.app.application.useCases.CityUseCaseImpl;

import com.konex.app.domain.model.City;
import com.konex.app.domain.ports.in.CityUseCase.UpdateCityUseCase;
import com.konex.app.domain.ports.out.CityRepositoryPort;
import java.util.Optional;

public class UpdateCityUseCaseImpl implements UpdateCityUseCase {

    private final CityRepositoryPort cityRepositoryPort;

    public UpdateCityUseCaseImpl(CityRepositoryPort cityRepositoryPort) {
        this.cityRepositoryPort = cityRepositoryPort;
    }

    @Override
    public Optional<City> updateCity(Long id, City updateCity) {
        return cityRepositoryPort.update(updateCity);
    }
}