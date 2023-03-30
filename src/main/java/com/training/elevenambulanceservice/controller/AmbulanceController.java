package com.training.elevenambulanceservice.controller;


import com.training.elevenambulanceservice.model.Address;
import com.training.elevenambulanceservice.model.Ambulance;
import com.training.elevenambulanceservice.model.dto.AmbulanceDTO;
import com.training.elevenambulanceservice.model.dto.AmbulancePhoneNumberDTO;
import com.training.elevenambulanceservice.model.dto.ErrorDTO;
import com.training.elevenambulanceservice.service.AmbulanceService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AmbulanceController {

     /*
        HTTP Methods :
        1. GET - Asking for already stored data
        2. POST - If you want to store some information in the database
        3. PUT - Already saved information update
        4. PATCH - Already saved information update but single value
        5. DELETE - If you want to delete the data
    */

    /*

    // SUCCESSFUL
    200 => OK
    201 => CREATED
    204 => NO_CONTENT

    // CLIENT_ERROR
    400 => BAD REQUEST
    401 => UN AUTHORIZED
    404 => NOT CONTENT FOUND
    422 => UNPROCESSABLE ENTITY (DATA RECEIVED BUT IS INVALID)

    // SERVER_ERROR
    500 => INTERNAL SERVER ERROR

     */

    @Autowired
    private AmbulanceService ambulanceService;

    @GetMapping(value = "/api/v1/ping")
    public String ping(){
        return "Ping Success";
    }

    @Operation(summary = "Get list of all ambulance available")
    @GetMapping(value = "/api/v1/list-ambulance")
    public ResponseEntity<List<Ambulance>> listAllAmbulance(){
        var listOfAmbulance = ambulanceService.getListOfAmbulance();
        return ResponseEntity.status(HttpStatus.OK).body(listOfAmbulance);
    }

    @GetMapping(value = "/api/v1/get-ambulance/{id}")
    public ResponseEntity<Ambulance> getAmbulanceDetail(@PathVariable(value = "id") Long ambulanceId){
        return ResponseEntity.status(200).body(ambulanceService.getAmbulanceDetail(ambulanceId));
    }

    @Operation(summary = "Create Ambulance")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ambulance stored successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Ambulance.class))
                    }),
            @ApiResponse(responseCode = "422", description = "If invalid Data",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDTO.class))
                    })
    })
    @PostMapping(value = "/api/v1/create-ambulance")
    public ResponseEntity<Ambulance> createAmbulance(@RequestBody @Valid AmbulanceDTO ambulanceDTO){
        System.out.println(ambulanceDTO);
        Ambulance savedAmbulance = ambulanceService.saveAmbulance(ambulanceDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAmbulance);
    }

    @PutMapping(value = "/api/v1/update-ambulance/{id}")
    public ResponseEntity<Ambulance> updateAmbulance(@PathVariable(value = "id") Long ambulanceId, @RequestBody AmbulanceDTO ambulanceDTO){
        return ResponseEntity.status(200).body(ambulanceService.updateAmbulanceData(ambulanceId, ambulanceDTO));
    }

    @PatchMapping(value = "/api/v1/update-ambulance-phone/{id}")
    public ResponseEntity<Ambulance> updateAmbulancePhoneNumber(@PathVariable(value = "id") Long ambulanceId, @RequestBody AmbulancePhoneNumberDTO ambulancePhoneNumberDTO){
        Ambulance ambulance1 = new Ambulance(1L,"Alka Hospital", "Jawlakhel", "533392");
        return ResponseEntity.status(200).body(ambulance1);
    }

    @DeleteMapping(value = "/api/v1/delete-ambulance/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Deleted Successfully"),
            @ApiResponse(responseCode = "500", description = "Hospital not found")
    })
    public ResponseEntity deleteAmbulance(@PathVariable(value = "id") Long ambulanceId){
       ambulanceService.deleteAmbulance(ambulanceId);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
