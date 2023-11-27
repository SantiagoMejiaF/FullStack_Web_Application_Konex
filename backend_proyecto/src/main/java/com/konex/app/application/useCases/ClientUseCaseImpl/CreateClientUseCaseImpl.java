package com.konex.app.application.useCases.ClientUseCaseImpl;

import com.konex.app.domain.model.Client;
import com.konex.app.domain.ports.in.ClientUseCase.CreateClientUseCase;
import com.konex.app.domain.ports.out.ClientRepositoryPort;

import java.util.List;

public class CreateClientUseCaseImpl implements CreateClientUseCase {

    private final ClientRepositoryPort clientRepositoryPort;

    public CreateClientUseCaseImpl(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public Client createClient(Client client) {
        return clientRepositoryPort.save(client);
    }

    @Override
    public List<Client> createClients(List<Client> Clients) {
        return clientRepositoryPort.saveAll(Clients);
    }
}