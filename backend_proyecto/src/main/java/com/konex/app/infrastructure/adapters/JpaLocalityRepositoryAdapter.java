package com.konex.app.infrastructure.adapters;

import com.konex.app.domain.model.Concessionaire;
import com.konex.app.domain.model.Locality;
import com.konex.app.domain.ports.out.LocalityRepositoryPort;
import com.konex.app.infrastructure.entities.ConcessionaireEntity;
import com.konex.app.infrastructure.entities.LocalityEntity;
import com.konex.app.infrastructure.repositories.JpaLocalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaLocalityRepositoryAdapter implements LocalityRepositoryPort {

    @Autowired
    private JpaLocalityRepository jpaLocalityRepository;

    @Override
    public Locality save(Locality locality) {
        LocalityEntity localityEntity = LocalityEntity.fromDomainModel(locality);
        LocalityEntity savedLocalityEntity = jpaLocalityRepository.save(localityEntity);
        return savedLocalityEntity.toDomainModel();
    }

    @Override
    public List<Locality> saveAll(List<Locality> localities) {
        List<LocalityEntity> localityEntities = localities.stream().map(LocalityEntity::fromDomainModel)
                .collect(java.util.stream.Collectors.toList());
        List<LocalityEntity> savedLocalityEntities = jpaLocalityRepository.saveAll(localityEntities);
        return savedLocalityEntities.stream().map(LocalityEntity::toDomainModel)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public Optional<Locality> update(Locality locality) {
        if(jpaLocalityRepository.existsById(locality.getId())){
            LocalityEntity localityEntity = LocalityEntity.fromDomainModel(locality);
            LocalityEntity updatedLocalityEntity = jpaLocalityRepository.save(localityEntity);
            return Optional.of(updatedLocalityEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Locality> findById(Long id) {
        return jpaLocalityRepository.findById(id).map(LocalityEntity::toDomainModel);
    }

    @Override
    public List<Locality> findAll() {
        return jpaLocalityRepository.findAll().stream().map(LocalityEntity::toDomainModel)
                .collect(java.util.stream.Collectors.toList());
    }
}