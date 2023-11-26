package com.konex.app.application.useCases;

import com.konex.app.domain.model.Client;
import com.konex.app.domain.ports.in.UpdateClientUseCase;
import com.konex.app.domain.ports.out.ClientRepositoryPort;
import java.util.Optional;

public class UpdateClientUseCaseImpl implements UpdateClientUseCase {

    private final ClientRepositoryPort clientRepositoryPort;

    public UpdateClientUseCaseImpl(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public Optional<Client> updateClient(Long id, Client updateClient) {
        return clientRepositoryPort.update(updateClient);
    }
}
