package com.training.elevenambulanceservice.controlleradvice;

import com.training.elevenambulanceservice.exceptions.AmbulanceNotFoundException;
import com.training.elevenambulanceservice.model.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AmbulanceControllerAdvice {

    @ExceptionHandler(AmbulanceNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleAmbulanceNotFoundException(AmbulanceNotFoundException exception){

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setErrorCode(10001);
        errorDTO.setErrorMessage(exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }

}
