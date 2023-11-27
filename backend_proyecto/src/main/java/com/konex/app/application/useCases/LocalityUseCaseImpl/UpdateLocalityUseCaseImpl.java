package com.konex.app.application.useCases.LocalityUseCaseImpl;
import com.konex.app.domain.model.Locality;
import com.konex.app.domain.ports.in.LocalityUseCase.UpdateLocalityUseCase;
import com.konex.app.domain.ports.out.LocalityRepositoryPort;

import java.util.Optional;


public class UpdateLocalityUseCaseImpl implements UpdateLocalityUseCase {

    private final LocalityRepositoryPort localityRepositoryPort;

    public UpdateLocalityUseCaseImpl(LocalityRepositoryPort localityRepositoryPort) {
        this.localityRepositoryPort = localityRepositoryPort;
    }

    @Override
    public Optional<Locality> updateLocality(Long id, Locality updateLocality) {
        return localityRepositoryPort.update(updateLocality);
    }
}