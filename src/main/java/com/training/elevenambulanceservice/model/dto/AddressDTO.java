package com.training.elevenambulanceservice.model.dto;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data
public class AddressDTO {

    private String country;

    private  String state;

    private  String street;
}
