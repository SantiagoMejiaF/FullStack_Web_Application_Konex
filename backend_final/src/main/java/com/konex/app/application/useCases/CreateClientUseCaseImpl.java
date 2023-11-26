package com.konex.app.application.useCases;

import com.konex.app.domain.model.Client;
import com.konex.app.domain.ports.in.CreateClientUseCase;
import com.konex.app.domain.ports.out.ClientRepositoryPort;

public class CreateClientUseCaseImpl implements CreateClientUseCase {

    private final ClientRepositoryPort clientRepositoryPort;

    public CreateClientUseCaseImpl(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public Client createClient(Client client) {
        return clientRepositoryPort.save(client);
    }
}