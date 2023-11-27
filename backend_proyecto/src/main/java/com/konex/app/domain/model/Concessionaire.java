package com.konex.app.domain.model;

import lombok.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Concessionaire {

    private Long id;
    private String concessionaireName;
    private City city;
}