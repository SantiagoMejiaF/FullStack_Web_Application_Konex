package com.konex.app.domain.ports.out;

import com.konex.app.domain.model.City;
import com.konex.app.domain.model.Client;

import java.util.List;
import java.util.Optional;

public interface CityRepositoryPort {

    City save(City city);
    List<City> saveAll(List<City> cities);
    Optional<City> findById(Long id);
    List<City> findAll();
    Optional<City> update(City city);
}