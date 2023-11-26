package com.konex.app.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {

    private Long id;
    private String fullName;
    private String idNumber;
    private String address;
    private String phoneNumber;
    private String email;
}