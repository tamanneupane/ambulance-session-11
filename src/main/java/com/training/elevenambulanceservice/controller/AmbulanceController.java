package com.training.elevenambulanceservice.controller;


import com.training.elevenambulanceservice.model.Ambulance;
import com.training.elevenambulanceservice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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
    public String listAllAmbulance(){
        Ambulance ambulance = new Ambulance("A", "B", "C");
        System.out.println(ambulance);
        return "List of ambulance";
    }

    @PostMapping(value = "/api/v1/create-ambulance")
    public String createAmbulance(){
        return "Ambulance Created";
    }

    @PutMapping(value = "/api/v1/update-ambulance")
    public String updateAmbulance(){
        return "Ambulance updated";
    }

    @PatchMapping(value = "/api/v1/update-ambulance-phone")
    public String updateAmbulancePhoneNumber(){
        return "Ambulance phone updated";
    }

    @DeleteMapping(value = "/api/v1/delete-ambulance")
    public String deleteAmbulance(){
        return "Ambulance Deleted";
    }
}
