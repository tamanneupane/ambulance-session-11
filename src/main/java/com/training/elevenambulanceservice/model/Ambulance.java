package com.training.elevenambulanceservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@ToString
public class Ambulance {

    @Getter
    private String hospitalName;

    @Getter
    private String location;

    @Getter
    @Setter
    private String phoneNumber;

    public Ambulance(String hospitalName, String location) {
        this.hospitalName = hospitalName;
        this.location = location;
    }
}
