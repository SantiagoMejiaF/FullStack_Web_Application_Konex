package com.konex.app.application.useCases;

import com.konex.app.domain.ports.in.DeleteClientUseCase;
import com.konex.app.domain.ports.out.ClientRepositoryPort;

public class DeleteClientUseCaseImpl implements DeleteClientUseCase {

    private final ClientRepositoryPort clientRepositoryPort;

    public DeleteClientUseCaseImpl(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public boolean deleteClient(Long id) {
        return clientRepositoryPort.deleteById(id);
    }
}