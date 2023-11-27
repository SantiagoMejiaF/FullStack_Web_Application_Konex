package com.konex.app.domain.ports.in.CityUseCase;

import com.konex.app.domain.model.City;
import java.util.Optional;

public interface UpdateCityUseCase {

    Optional<City> updateCity(Long id, City city);
}