package com.konex.app.domain.ports.out;

import com.konex.app.domain.model.Locality;
import java.util.List;
import java.util.Optional;

public interface LocalityRepositoryPort {

    Locality save(Locality locality);
    List<Locality> saveAll(List<Locality> localities);
    Optional<Locality> update(Locality locality);
    Optional<Locality> findById(Long id);
    List<Locality> findAll();
}