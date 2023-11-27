package com.konex.app.infrastructure.config;

import com.konex.app.application.services.CityService;
import com.konex.app.application.services.ClientService;
import com.konex.app.application.services.ConcessionaireService;
import com.konex.app.application.services.LocalityService;
import com.konex.app.application.useCases.CityUseCaseImpl.CreateCityUseCaseImpl;
import com.konex.app.application.useCases.CityUseCaseImpl.ReadCityUseCaseImpl;
import com.konex.app.application.useCases.CityUseCaseImpl.UpdateCityUseCaseImpl;
import com.konex.app.application.useCases.ClientUseCaseImpl.CreateClientUseCaseImpl;
import com.konex.app.application.useCases.ClientUseCaseImpl.DeleteClientUseCaseImpl;
import com.konex.app.application.useCases.ClientUseCaseImpl.ReadClientUseCaseImpl;
import com.konex.app.application.useCases.ClientUseCaseImpl.UpdateClientUseCaseImpl;
import com.konex.app.application.useCases.ConcessionaireUseCaseImpl.CreateConcessionaireUseCaseImpl;
import com.konex.app.application.useCases.ConcessionaireUseCaseImpl.ReadConcessionaireUseCaseImpl;
import com.konex.app.application.useCases.ConcessionaireUseCaseImpl.UpdateConcessionaireUseCaseImpl;
import com.konex.app.application.useCases.LocalityUseCaseImpl.CreateLocalityUseCaseImpl;
import com.konex.app.application.useCases.LocalityUseCaseImpl.ReadLocalityUseCaseImpl;
import com.konex.app.application.useCases.LocalityUseCaseImpl.UpdateLocalityUseCaseImpl;
import com.konex.app.domain.ports.in.CityUseCase.UpdateCityUseCase;
import com.konex.app.domain.ports.in.ConcessionaireUseCase.UpdateConcessionaireUseCase;
import com.konex.app.domain.ports.out.CityRepositoryPort;
import com.konex.app.domain.ports.out.ClientRepositoryPort;
import com.konex.app.domain.ports.out.ConcessionaireRepositoryPort;
import com.konex.app.domain.ports.out.LocalityRepositoryPort;
import com.konex.app.infrastructure.adapters.JpaCityRepositoryAdapter;
import com.konex.app.infrastructure.adapters.JpaClientRepositoryAdapter;
import com.konex.app.infrastructure.adapters.JpaConcessionaireRepositoryAdapter;
import com.konex.app.infrastructure.adapters.JpaLocalityRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    ClientService clientService(ClientRepositoryPort clientRepositoryPort) {
        return new ClientService(
                new CreateClientUseCaseImpl(clientRepositoryPort),
                new ReadClientUseCaseImpl(clientRepositoryPort),
                new UpdateClientUseCaseImpl(clientRepositoryPort),
                new DeleteClientUseCaseImpl(clientRepositoryPort)
        );
    }

    @Bean
    ClientRepositoryPort clientRepositoryPort(JpaClientRepositoryAdapter jpaClientRepositoryAdapter) {
        return jpaClientRepositoryAdapter;
    }

    @Bean
    CityService cityService(CityRepositoryPort cityRepositoryPort) {
        return new CityService(
                new CreateCityUseCaseImpl(cityRepositoryPort),
                new ReadCityUseCaseImpl(cityRepositoryPort),
                new UpdateCityUseCaseImpl(cityRepositoryPort)
        );
    }

    @Bean
    CityRepositoryPort cityRepositoryPort(JpaCityRepositoryAdapter jpaCityRepositoryAdapter) {
        return jpaCityRepositoryAdapter;
    }

    @Bean
    ConcessionaireService concessionaireService(ConcessionaireRepositoryPort concessionaireRepositoryPort){
        return new ConcessionaireService(
                new CreateConcessionaireUseCaseImpl(concessionaireRepositoryPort),
                new ReadConcessionaireUseCaseImpl(concessionaireRepositoryPort),
                new UpdateConcessionaireUseCaseImpl(concessionaireRepositoryPort)
        );
    }

    @Bean
    ConcessionaireRepositoryPort concessionaireRepositoryPort(JpaConcessionaireRepositoryAdapter jpaConcessionaireRepositoryAdapter){
        return jpaConcessionaireRepositoryAdapter;
    }

    @Bean
    LocalityService localityService(LocalityRepositoryPort localityRepositoryPort){
        return new LocalityService(
                new CreateLocalityUseCaseImpl(localityRepositoryPort),
                new ReadLocalityUseCaseImpl(localityRepositoryPort),
                new UpdateLocalityUseCaseImpl(localityRepositoryPort)
        );
    }

    @Bean
    LocalityRepositoryPort localityRepositoryPort(JpaLocalityRepositoryAdapter jpaLocalityRepositoryAdapter){
        return jpaLocalityRepositoryAdapter;
    }
}