package com.training.elevenambulanceservice.model;


import lombok.*;

import java.util.List;


@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Ambulance {

    @Getter
    private Long ambulanceId;

    @Getter
    private String hospitalName;

    @Getter
    private String location;

    @Getter
    @Setter
    private String phoneNumber;

    @Getter
    private Address address;

    @Getter
    private List<String> phoneNumbers;



    public Ambulance(String hospitalName, String location) {
        this.hospitalName = hospitalName;
        this.location = location;
    }
}
