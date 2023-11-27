package com.konex.app.infrastructure.adapters;

import com.konex.app.domain.model.Client;
import com.konex.app.domain.ports.out.ClientRepositoryPort;
import com.konex.app.infrastructure.entities.ClientEntity;
import com.konex.app.infrastructure.repositories.JpaClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaClientRepositoryAdapter implements ClientRepositoryPort {

    @Autowired
    private JpaClientRepository jpaClientRepository;

    @Override
    public Client save(Client client) {
        ClientEntity clientEntity = ClientEntity.fromDomainModel(client);
        ClientEntity savedClientEntity = jpaClientRepository.save(clientEntity);
        return savedClientEntity.toDomainModel();
    }

    @Override
    public List<Client> saveAll(List<Client> clients) {
        return jpaClientRepository.saveAll(clients.stream().map(ClientEntity::fromDomainModel)
                .collect(Collectors.toList())).stream().map(ClientEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Client> findById(Long id) {
        return jpaClientRepository.findById(id).map(ClientEntity::toDomainModel);
    }

    @Override
    public List<Client> findAll() {
        return jpaClientRepository.findAll().stream().map(ClientEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Client> update(Client client) {
        if(jpaClientRepository.existsById(client.getId())){
            ClientEntity clientEntity = ClientEntity.fromDomainModel(client);
            ClientEntity updatedClientEntity = jpaClientRepository.save(clientEntity);
            return Optional.of(updatedClientEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if(jpaClientRepository.existsById(id)){
            jpaClientRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<String> findAllClientsNames() {
        return jpaClientRepository.findAll().stream().map(ClientEntity::getFullName)
                .collect(Collectors.toList());
    }
}