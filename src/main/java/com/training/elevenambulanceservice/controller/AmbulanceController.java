package com.training.elevenambulanceservice.controller;


import com.training.elevenambulanceservice.model.Address;
import com.training.elevenambulanceservice.model.Ambulance;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AmbulanceController {

     /*
        HTTP Methods :
        1. GET - Asking for already stored data
        2. POST - If you want to store some information in the server
        3. PUT - Already saved information update
        4. PATCH - Already saved information update but single value
        5. DELETE - If you want to delete the data
    */

    @GetMapping(value = "/api/v1/ping")
    public String ping(){
        return "Ping Success";
    }

    @GetMapping(value = "/api/v1/list-ambulance")
    public List<Ambulance> listAllAmbulance(){
        Address address1 = new Address();
        Ambulance ambulance1 = new Ambulance("Alka Hospital", "Jawlakhel", "533392", address1,  List.of());
        Ambulance ambulance2 = new Ambulance("Sumeru Hospital", "Damkal", "533393", address1,  List.of());
        Ambulance ambulance3 = new Ambulance("Medicity Hospital", "Eekanta Kuna", "599994", address1,  List.of());
        List<Ambulance> list = new ArrayList<>();
        list.add(ambulance1);
        list.add(ambulance2);
        list.add(ambulance3);
        return list;
    }

    @PostMapping(value = "/api/v1/create-ambulance")
    public Ambulance createAmbulance(){
        Address address1 = new Address();
        Ambulance ambulance1 = new Ambulance("Alka Hospital", "Jawlakhel", "533392", address1, List.of());
        return ambulance1;
    }

    @PutMapping(value = "/api/v1/update-ambulance")
    public Ambulance updateAmbulance(){
        Address address1 = new Address();
        Ambulance ambulance1 = new Ambulance("Alka Hospital", "Jawlakhel", "533392", address1,  List.of());
        return ambulance1;
    }

    @PatchMapping(value = "/api/v1/update-ambulance-phone")
    public Ambulance updateAmbulancePhoneNumber(){
        Address address1 = new Address();
        Ambulance ambulance1 = new Ambulance("Alka Hospital", "Jawlakhel", "533392", address1,  List.of());
        return ambulance1;
    }

    @DeleteMapping(value = "/api/v1/delete-ambulance")
    public String deleteAmbulance(){
        return "Ambulance Deleted";
    }
}
