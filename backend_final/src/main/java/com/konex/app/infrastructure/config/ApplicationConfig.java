package com.konex.app.infrastructure.config;

import com.konex.app.application.services.ClientService;
import com.konex.app.application.useCases.CreateClientUseCaseImpl;
import com.konex.app.application.useCases.DeleteClientUseCaseImpl;
import com.konex.app.application.useCases.ReadClientUseCaseImpl;
import com.konex.app.application.useCases.UpdateClientUseCaseImpl;
import com.konex.app.domain.ports.out.ClientRepositoryPort;
import com.konex.app.infrastructure.adapters.JpaClientRepositoryPortAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ClientService clientService(ClientRepositoryPort clientRepositoryPort) {
        return new ClientService(
                new CreateClientUseCaseImpl(clientRepositoryPort),
                new ReadClientUseCaseImpl(clientRepositoryPort),
                new UpdateClientUseCaseImpl(clientRepositoryPort),
                new DeleteClientUseCaseImpl(clientRepositoryPort)
        );
    }

    @Bean
    ClientRepositoryPort clientRepositoryPort(JpaClientRepositoryPortAdapter jpaClientRepositoryPortAdapter) {
        return jpaClientRepositoryPortAdapter;
    }
}