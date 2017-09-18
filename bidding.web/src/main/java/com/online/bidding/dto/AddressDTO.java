package com.online.bidding.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class AddressDTO {

    private String street;
    private String city;
    private String state;
    private String country;

}
