package com.konex.app.domain.ports.in.ClientUseCase;

import com.konex.app.domain.model.Client;
import java.util.List;
import java.util.Optional;

public interface ReadClientUseCase {

    Optional<Client> getClientById(Long id);
    List<Client> getAllClients();
}