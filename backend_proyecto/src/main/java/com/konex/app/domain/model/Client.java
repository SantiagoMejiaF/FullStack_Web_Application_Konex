package com.konex.app.domain.model;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {

    private Long id;
    private String fullName;
    private String idNumber;
    private String address;
    private String phoneNumber;
    private String email;
    private Locality locality;
}