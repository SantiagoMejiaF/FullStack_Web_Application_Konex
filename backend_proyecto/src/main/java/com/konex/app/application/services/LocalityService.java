package com.konex.app.application.services;

import com.konex.app.domain.model.Locality;
import com.konex.app.domain.ports.in.LocalityUseCase.CreateLocalityUseCase;
import com.konex.app.domain.ports.in.LocalityUseCase.ReadLocalityUseCase;
import com.konex.app.domain.ports.in.LocalityUseCase.UpdateLocalityUseCase;
import java.util.List;
import java.util.Optional;

public class LocalityService implements CreateLocalityUseCase, ReadLocalityUseCase, UpdateLocalityUseCase {

    private final CreateLocalityUseCase createLocalityUseCase;
    private final UpdateLocalityUseCase updateLocalityUseCase;
    private final ReadLocalityUseCase readLocalityUseCase;

    public LocalityService(CreateLocalityUseCase createLocalityUseCase, ReadLocalityUseCase readLocalityUseCase,
                           UpdateLocalityUseCase updateLocalityUseCase) {
        this.createLocalityUseCase = createLocalityUseCase;
        this.updateLocalityUseCase = updateLocalityUseCase;
        this.readLocalityUseCase = readLocalityUseCase;
    }

    @Override
    public Locality createLocality(Locality locality) {
        return createLocalityUseCase.createLocality(locality);
    }

    @Override
    public List<Locality> createLocalities(List<Locality> localities) {
        return createLocalityUseCase.createLocalities(localities);
    }

    @Override
    public Optional<Locality> updateLocality(Long id, Locality locality) {
        return updateLocalityUseCase.updateLocality(id, locality);
    }

    @Override
    public Optional<Locality> getLocalityById(Long id) {
        return readLocalityUseCase.getLocalityById(id);
    }

    @Override
    public List<Locality> getAllLocalities() {
        return readLocalityUseCase.getAllLocalities();
    }
}