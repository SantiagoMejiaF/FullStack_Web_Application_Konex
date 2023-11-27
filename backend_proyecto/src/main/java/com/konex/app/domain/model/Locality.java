package com.konex.app.domain.model;

import lombok.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Locality {

    private Long id;
    private String localityName;
    private Concessionaire concessionaire;
}