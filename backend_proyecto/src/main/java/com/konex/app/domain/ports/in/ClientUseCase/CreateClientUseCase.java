package com.konex.app.domain.ports.in.ClientUseCase;

import com.konex.app.domain.model.City;
import com.konex.app.domain.model.Client;

import java.util.List;

public interface CreateClientUseCase {

    Client createClient(Client client);
    List<Client> createClients(List<Client> Clients);
}