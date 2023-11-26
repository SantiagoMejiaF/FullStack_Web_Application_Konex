package com.konex.app.application.services;

import com.konex.app.domain.model.Client;
import com.konex.app.domain.ports.in.UpdateClientUseCase;
import com.konex.app.domain.ports.in.ReadClientUseCase;
import com.konex.app.domain.ports.in.DeleteClientUseCase;
import com.konex.app.domain.ports.in.CreateClientUseCase;
import java.util.List;
import java.util.Optional;

public class ClientService implements UpdateClientUseCase, ReadClientUseCase,
        DeleteClientUseCase, CreateClientUseCase{

    private final UpdateClientUseCase updateClientUseCase;
    private final ReadClientUseCase readClientUseCase;
    private final DeleteClientUseCase deleteClientUseCase;
    private final CreateClientUseCase createClientUseCase;

    public ClientService(CreateClientUseCase createClientUseCase, ReadClientUseCase readClientUseCase, UpdateClientUseCase updateClientUseCase,  DeleteClientUseCase deleteClientUseCase) {
        this.updateClientUseCase = updateClientUseCase;
        this.readClientUseCase = readClientUseCase;
        this.deleteClientUseCase = deleteClientUseCase;
        this.createClientUseCase = createClientUseCase;
    }

    @Override
    public Client createClient(Client client) {
        return createClientUseCase.createClient(client);
    }

    @Override
    public boolean deleteClient(Long id) {
        return deleteClientUseCase.deleteClient(id);
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        return readClientUseCase.getClientById(id);
    }

    @Override
    public List<Client> getAllClients() {
        return readClientUseCase.getAllClients();
    }

    @Override
    public Optional<Client> updateClient(Long id, Client client) {
        return updateClientUseCase.updateClient(id, client);
    }
}