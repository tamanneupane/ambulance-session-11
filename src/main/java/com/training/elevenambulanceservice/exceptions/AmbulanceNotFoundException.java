package com.training.elevenambulanceservice.exceptions;

import lombok.Getter;

@Getter
public class AmbulanceNotFoundException extends RuntimeException {

    public String message;

    public AmbulanceNotFoundException(String message){
        super(message);
        this.message = message;
    }
}
