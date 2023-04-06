package com.training.elevenambulanceservice.model.dto;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;


@AllArgsConstructor
@ToString
@NoArgsConstructor
public class AmbulanceDTO {

    @NotBlank(message = "Hospital Name cannot be empty")
    @Getter
    private String hospitalName;

    @Getter
    @Setter
    private AddressDTO address;

    @Getter
    @Setter
//    @Pattern(regexp = "(?:\\(?\\+977\\)?)?[9][6-9]\\d{8}|01[-]?[0-9]{7}", message = "Mobile number is not valid")
    private List<String> phoneNumber;

//    @Getter
//    private Address address;
//
//    @Getter
//    private List<String> phoneNumbers;

}
