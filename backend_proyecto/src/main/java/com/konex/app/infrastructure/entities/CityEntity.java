package com.konex.app.infrastructure.entities;

import com.konex.app.domain.model.City;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "cities")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cityName;

    public static CityEntity fromDomainModel(City city) {
        return CityEntity.builder()
                .id(city.getId())
                .cityName(city.getCityName())
                .build();
    }

    public City toDomainModel() {
        return City.builder()
                .id(this.id)
                .cityName(this.cityName)
                .build();
    }
}