package com.konex.app.application.useCases.LocalityUseCaseImpl;

import com.konex.app.domain.model.Locality;
import com.konex.app.domain.ports.in.LocalityUseCase.CreateLocalityUseCase;
import com.konex.app.domain.ports.out.LocalityRepositoryPort;
import java.util.List;

public class CreateLocalityUseCaseImpl implements CreateLocalityUseCase {

    private final LocalityRepositoryPort localityRepositoryPort;

    public CreateLocalityUseCaseImpl(LocalityRepositoryPort localityRepositoryPort) {
        this.localityRepositoryPort = localityRepositoryPort;
    }

    @Override
    public Locality createLocality(Locality locality) {
        return localityRepositoryPort.save(locality);
    }

    @Override
    public List<Locality> createLocalities(List<Locality> localities) {
        return localityRepositoryPort.saveAll(localities);
    }
}