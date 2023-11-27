package com.konex.app.application.useCases.ClientUseCaseImpl;

import com.konex.app.domain.model.Client;
import com.konex.app.domain.ports.in.ClientUseCase.ReadClientUseCase;
import com.konex.app.domain.ports.out.ClientRepositoryPort;
import java.util.List;
import java.util.Optional;

public class ReadClientUseCaseImpl implements ReadClientUseCase {

    private final ClientRepositoryPort clientRepositoryPort;

    public ReadClientUseCaseImpl(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        return clientRepositoryPort.findById(id);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepositoryPort.findAll();
    }
}