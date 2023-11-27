package com.konex.app.infrastructure.entities;

import com.konex.app.domain.model.Locality;
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
@Table(name = "localities")
public class LocalityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String localityName;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "concessionaire_id")
    private ConcessionaireEntity concessionaire;

    public static LocalityEntity fromDomainModel(Locality locality) {
        if (locality == null) {
            return null;
        }
        return LocalityEntity.builder()
                .id(locality.getId())
                .localityName(locality.getLocalityName())
                .concessionaire(ConcessionaireEntity.fromDomainModel(locality.getConcessionaire()))
                .build();
    }

    public Locality toDomainModel() {
        return Locality.builder()
                .id(this.id)
                .localityName(this.localityName)
                .concessionaire(this.concessionaire.toDomainModel())
                .build();
    }
}