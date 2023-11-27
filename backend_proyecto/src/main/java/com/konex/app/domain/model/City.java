package com.konex.app.domain.model;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class City {

    private Long id;
    private String cityName;
    private List<Locality> localities;
}