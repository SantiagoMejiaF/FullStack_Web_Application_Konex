package com.konex.app.infrastructure.repositories;

import com.konex.app.application.services.ClientService;
import com.konex.app.infrastructure.entities.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class H2DatabaseInitializer implements ApplicationRunner {

    @Autowired
    private ClientService clientService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        ClientEntity client1 = ClientEntity.builder()
                .fullName("Juan Perez Aguilar")
                .idNumber("1000286136")
                .phoneNumber("3223045823")
                .address("Carrera 8f #166-34")
                .email("j.perez@outlook.com")
                .build();

        ClientEntity client2 = ClientEntity.builder()
                .fullName("Maria Gonzalez Sanchez")
                .idNumber("1000742861")
                .phoneNumber("3117415848")
                .address("Calle 23 # 12-34")
                .email("m.gonzalez@gmail.com")
                .build();


        ClientEntity client3 = ClientEntity.builder()
                .fullName("Camila Rocha Mejia")
                .idNumber("1000486287")
                .phoneNumber("3184588521")
                .address("Calle 45 # 23-12")
                .email("c.rocha@hotmail.com")
                .build();

        clientService.createClient(client1.toDomainModel());
        clientService.createClient(client2.toDomainModel());
        clientService.createClient(client3.toDomainModel());
    }
}