package com.konex.app.infrastructure.entities;

import com.konex.app.domain.model.Client;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String idNumber;
    private String address;
    private String phoneNumber;
    private String email;

    public static ClientEntity fromDomainModel(Client client) {
        return new ClientEntity(
                client.getId(),
                client.getFullName(),
                client.getIdNumber(),
                client.getAddress(),
                client.getPhoneNumber(),
                client.getEmail()
        );
    }

    public Client toDomainModel() {
        return new Client(
                this.id,
                this.fullName,
                this.idNumber,
                this.address,
                this.phoneNumber,
                this.email
        );
    }
}