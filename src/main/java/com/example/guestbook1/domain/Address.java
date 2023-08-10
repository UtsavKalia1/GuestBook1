package com.example.guestbook1.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private int addressId;
    private String city;
    private String postalCode;

}
