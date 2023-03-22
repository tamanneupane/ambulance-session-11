package com.training.elevenambulanceservice.model.dto;


import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@ToString
@NoArgsConstructor
public class AmbulanceDTO {

    @Getter
    private String hospitalName;

    @Getter
    private String location;

    @Getter
    @Setter
    private String phoneNumber;

//    @Getter
//    private Address address;
//
//    @Getter
//    private List<String> phoneNumbers;

}
