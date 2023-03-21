package com.training.elevenambulanceservice.controller;


import com.training.elevenambulanceservice.model.Address;
import com.training.elevenambulanceservice.model.Ambulance;
import com.training.elevenambulanceservice.model.dto.AmbulanceDTO;
import com.training.elevenambulanceservice.service.AmbulanceService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private AmbulanceService ambulanceService;

    @GetMapping(value = "/api/v1/ping")
    public String ping(){
        return "Ping Success";
    }

    @GetMapping(value = "/api/v1/list-ambulance")
    public List<Ambulance> listAllAmbulance(){
        var listOfAmbulance = ambulanceService.getListOfAmbulance();
        return listOfAmbulance;
    }

    @GetMapping(value = "/api/v1/get-ambulance/{id}")
    public Long getAmbulanceDetail(@PathVariable(value = "id") Long ambulanceId){
        AmbulanceService ambulanceService = new AmbulanceService();
        System.out.println(ambulanceId);
        return ambulanceId;
    }

    @PostMapping(value = "/api/v1/create-ambulance")
    public AmbulanceDTO createAmbulance(@RequestBody AmbulanceDTO ambulanceDTO){
        AmbulanceService ambulanceService = new AmbulanceService();
        System.out.println(ambulanceDTO);
        return ambulanceDTO;
    }

    @PutMapping(value = "/api/v1/update-ambulance/{id}")
    public Ambulance updateAmbulance(@PathVariable(value = "id") Long ambulanceId, @RequestBody Ambulance ambulance){
        Ambulance ambulance1 = new Ambulance(1L,"Alka Hospital", "Jawlakhel", "533392");
        return ambulance1;
    }

    @PatchMapping(value = "/api/v1/update-ambulance-phone/{id}")
    public Ambulance updateAmbulancePhoneNumber(@PathVariable(value = "id") Long ambulanceId, @RequestBody List<String> phoneNumbers){
        Ambulance ambulance1 = new Ambulance(1L,"Alka Hospital", "Jawlakhel", "533392");
        return ambulance1;
    }

    @DeleteMapping(value = "/api/v1/delete-ambulance/{id}")
    public String deleteAmbulance(@PathVariable(value = "id") Long ambulanceId){
        AmbulanceService ambulanceService = new AmbulanceService();
        return "Ambulance Deleted";
    }
}
