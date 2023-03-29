package com.training.elevenambulanceservice.model.dto;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;


@AllArgsConstructor
@ToString
@NoArgsConstructor
public class AmbulanceDTO {

    @NotBlank(message = "Hospital Name cannot be empty")
    @Getter
    private String hospitalName;

    @NotBlank(message = "Location Name cannot be empty")
    @Getter
    private String location;

    @Getter
    @Setter
    @Pattern(regexp = "(?:\\(?\\+977\\)?)?[9][6-9]\\d{8}|01[-]?[0-9]{7}", message = "Mobile number is not valid")
    private String phoneNumber;

//    @Getter
//    private Address address;
//
//    @Getter
//    private List<String> phoneNumbers;

}
