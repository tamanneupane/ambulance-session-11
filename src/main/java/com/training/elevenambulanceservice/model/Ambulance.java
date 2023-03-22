package com.training.elevenambulanceservice.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
@Table(name = "ambulance_tbl")
public class Ambulance {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ambulanceId;

    @Getter
    @Setter
    @Column(length = 100)
    private String hospitalName;

    @Getter
    @Setter
    private String location;

    @Getter
    @Setter
    @Column(length = 15)
    private String phoneNumber;

//    @Getter
//    private Address address;
//
//    @Getter
//    private List<String> phoneNumbers;



    public Ambulance(String hospitalName, String location) {
        this.hospitalName = hospitalName;
        this.location = location;
    }
}
