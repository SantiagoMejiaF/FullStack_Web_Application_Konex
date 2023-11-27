package com.konex.app.infrastructure.entities;

import com.konex.app.domain.model.Client;
import com.konex.app.domain.model.Concessionaire;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "concessionaires")
public class ConcessionaireEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String concessionaireName;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "city_id")
    private CityEntity city;

    public static ConcessionaireEntity fromDomainModel(Concessionaire concessionaire) {
        return ConcessionaireEntity.builder()
                .id(concessionaire.getId())
                .concessionaireName(concessionaire.getConcessionaireName())
                .city(CityEntity.fromDomainModel(concessionaire.getCity()))
                .build();
    }

    public Concessionaire toDomainModel() {
        return Concessionaire.builder()
                .id(this.id)
                .concessionaireName(this.concessionaireName)
                .city(this.city.toDomainModel())
                .build();
    }
}