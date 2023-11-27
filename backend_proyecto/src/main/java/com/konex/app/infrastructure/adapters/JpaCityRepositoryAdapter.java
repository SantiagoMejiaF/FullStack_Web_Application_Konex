package com.konex.app.infrastructure.adapters;

import com.konex.app.domain.model.City;
import com.konex.app.domain.model.Client;
import com.konex.app.domain.ports.out.CityRepositoryPort;
import com.konex.app.infrastructure.entities.CityEntity;
import com.konex.app.infrastructure.entities.ClientEntity;
import org.springframework.stereotype.Component;
import com.konex.app.infrastructure.repositories.JpaCityRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaCityRepositoryAdapter implements CityRepositoryPort {

    private final JpaCityRepository jpaCityRepository;

    public JpaCityRepositoryAdapter(JpaCityRepository jpaCityRepository) {
        this.jpaCityRepository = jpaCityRepository;
    }

    @Override
    public City save(City city) {

        CityEntity cityEntity = CityEntity.fromDomainModel(city);
        CityEntity savedCityEntity = jpaCityRepository.save(cityEntity);
        return savedCityEntity.toDomainModel();
    }

    @Override
    public List<City> saveAll(List<City> cities) {
        List<CityEntity> cityEntities = cities.stream().map(CityEntity::fromDomainModel)
                .collect(java.util.stream.Collectors.toList());
        List<CityEntity> savedCityEntities = jpaCityRepository.saveAll(cityEntities);
        return savedCityEntities.stream().map(CityEntity::toDomainModel)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public Optional<City> update(City city) {
        if(jpaCityRepository.existsById(city.getId())){
            CityEntity cityEntity = CityEntity.fromDomainModel(city);
            CityEntity updatedCityEntity = jpaCityRepository.save(cityEntity);
            return Optional.of(updatedCityEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public List<String> findAllCitiesNames() {
        return jpaCityRepository.findAll().stream().map(CityEntity::getCityName)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public Long findCityIdByName(String name) {
        return jpaCityRepository.findCityIdByName(name);
    }

    @Override
    public Optional<City> findById(Long id) {
        return jpaCityRepository.findById(id).map(CityEntity::toDomainModel);
    }

    @Override
    public List<City> findAll() {
        return jpaCityRepository.findAll().stream().map(CityEntity::toDomainModel)
                .collect(Collectors.toList());
    }
}