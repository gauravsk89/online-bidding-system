package com.online.bidding.dto;

import com.online.bidding.domain.Phone;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class UserDTO {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String emailId;

    private AddressDTO address;

    private PhoneDTO phone;
}
