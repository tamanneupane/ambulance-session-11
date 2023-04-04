package com.training.elevenambulanceservice.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
@Table(name = "address_tbl")
public class Address {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;

    @Getter
    private String country;

    @Getter
    private  String state;

    @Getter
    private  String street;

    public Address(String country, String state, String street){
        this.country = country;
        this.state = state;
        this.street = street;
    }
}
