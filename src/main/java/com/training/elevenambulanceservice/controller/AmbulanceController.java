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
        Ambulance ambulance1 = new Ambulance(1L,"Alka Hospital", "Jawlakhel", "533392", address1,  List.of());
        Ambulance ambulance2 = new Ambulance(2L,"Sumeru Hospital", "Damkal", "533393", address1,  List.of());
        Ambulance ambulance3 = new Ambulance(3L, "Medicity Hospital", "Eekanta Kuna", "599994", address1,  List.of());
        List<Ambulance> list = new ArrayList<>();
        list.add(ambulance1);
        list.add(ambulance2);
        list.add(ambulance3);
        return list;
    }

    @GetMapping(value = "/api/v1/get-ambulance/{id}")
    public Long getAmbulance(@PathVariable(value = "id") Long ambulanceId){
        System.out.println(ambulanceId);
        return ambulanceId;
    }

    @PostMapping(value = "/api/v1/create-ambulance")
    public Ambulance createAmbulance(@RequestBody Ambulance ambulance){
        System.out.println(ambulance);
        return ambulance;
    }

    @PutMapping(value = "/api/v1/update-ambulance/{id}")
    public Ambulance updateAmbulance(@PathVariable(value = "id") Long ambulanceId, @RequestBody Ambulance ambulance){
        Address address1 = new Address();
        Ambulance ambulance1 = new Ambulance(1L,"Alka Hospital", "Jawlakhel", "533392", address1,  List.of());
        return ambulance1;
    }

    @PatchMapping(value = "/api/v1/update-ambulance-phone/{id}")
    public Ambulance updateAmbulancePhoneNumber(@PathVariable(value = "id") Long ambulanceId, @RequestBody List<String> phoneNumbers){
        Address address1 = new Address();
        Ambulance ambulance1 = new Ambulance(1L,"Alka Hospital", "Jawlakhel", "533392", address1,  List.of());
        return ambulance1;
    }

    @DeleteMapping(value = "/api/v1/delete-ambulance/{id}")
    public String deleteAmbulance(@PathVariable(value = "id") Long ambulanceId){
        return "Ambulance Deleted";
    }
}
