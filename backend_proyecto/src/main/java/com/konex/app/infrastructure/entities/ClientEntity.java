package com.konex.app.infrastructure.entities;

import com.konex.app.domain.model.Client;
import com.konex.app.domain.model.Concessionaire;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "clients")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String idNumber;
    private String address;
    private String phoneNumber;
    private String email;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "locality_id")
    private LocalityEntity locality;

    public static ClientEntity fromDomainModel(Client client) {
        return ClientEntity.builder()
                .id(client.getId())
                .fullName(client.getFullName())
                .idNumber(client.getIdNumber())
                .address(client.getAddress())
                .phoneNumber(client.getPhoneNumber())
                .email(client.getEmail())
                .locality(LocalityEntity.fromDomainModel(client.getLocality()))
                .build();
    }

    public Client toDomainModel() {
        return Client.builder()
                .id(this.id)
                .fullName(this.fullName)
                .idNumber(this.idNumber)
                .address(this.address)
                .phoneNumber(this.phoneNumber)
                .email(this.email)
                .locality(this.locality.toDomainModel())
                .build();
    }
}