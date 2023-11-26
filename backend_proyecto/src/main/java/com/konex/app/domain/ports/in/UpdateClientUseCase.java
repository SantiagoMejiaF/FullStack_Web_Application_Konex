package com.konex.app.domain.ports.in;

import com.konex.app.domain.model.Client;
import java.util.Optional;

public interface UpdateClientUseCase {

    Optional<Client> updateClient(Long id, Client client);
}