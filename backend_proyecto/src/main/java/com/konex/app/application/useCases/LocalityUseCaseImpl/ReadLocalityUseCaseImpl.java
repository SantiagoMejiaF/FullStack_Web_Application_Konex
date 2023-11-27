package com.konex.app.application.useCases.LocalityUseCaseImpl;

import com.konex.app.domain.model.Locality;
import com.konex.app.domain.ports.in.LocalityUseCase.ReadLocalityUseCase;
import com.konex.app.domain.ports.out.LocalityRepositoryPort;
import java.util.List;
import java.util.Optional;

public class ReadLocalityUseCaseImpl implements ReadLocalityUseCase {

    private final LocalityRepositoryPort localityRepositoryPort;

    public ReadLocalityUseCaseImpl(LocalityRepositoryPort localityRepositoryPort) {
        this.localityRepositoryPort = localityRepositoryPort;
    }

    @Override
    public Optional<Locality> getLocalityById(Long id) {
        return localityRepositoryPort.findById(id);
    }

    @Override
    public List<Locality> getAllLocalities() {
        return localityRepositoryPort.findAll();
    }

    @Override
    public List<String> getAllLocalitiesNames() {
        return localityRepositoryPort.findAllLocalitiesNames();
    }

    @Override
    public List<String> getAllLocalitiesByConcessionaireId(Long id) {
        return localityRepositoryPort.findAllLocalitiesByConcessionaireId(id);
    }
}