package com.konex.app.domain.ports.out;

import com.konex.app.domain.model.Client;
import java.util.List;
import java.util.Optional;

public interface ClientRepositoryPort {

    Client save(Client client);
    List<Client> saveAll(List<Client> clients);
    Optional<Client> findById(Long id);
    List<Client> findAll();
    Optional<Client> update(Client client);
    boolean deleteById(Long id);
}