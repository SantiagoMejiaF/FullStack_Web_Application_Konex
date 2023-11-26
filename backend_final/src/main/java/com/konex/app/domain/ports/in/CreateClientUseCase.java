package com.konex.app.domain.ports.in;

import com.konex.app.domain.model.Client;

public interface CreateClientUseCase {

    Client createClient(Client client);
}