package com.training.elevenambulanceservice.service;

import com.training.elevenambulanceservice.model.Address;
import com.training.elevenambulanceservice.model.Ambulance;
import com.training.elevenambulanceservice.model.dto.AmbulanceDTO;
import com.training.elevenambulanceservice.repository.AmbulanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmbulanceService {

    @Autowired
    private AmbulanceRepository ambulanceRepository;

    public List<Ambulance> getListOfAmbulance(){
        Address address1 = new Address();
        Ambulance ambulance1 = new Ambulance(1L,"Alka Hospital", "Jawlakhel", "533392");
        Ambulance ambulance2 = new Ambulance(2L,"Sumeru Hospital", "Damkal", "533393");
        Ambulance ambulance3 = new Ambulance(3L, "Medicity Hospital", "Eekanta Kuna", "599994");
        List<Ambulance> list = new ArrayList<>();
        list.add(ambulance1);
        list.add(ambulance2);
        list.add(ambulance3);

        return  list;
    }

    public Ambulance saveAmbulance(AmbulanceDTO ambulanceDTO){
        Ambulance ambulance = new Ambulance();
        ambulance.setPhoneNumber(ambulanceDTO.getPhoneNumber());
        ambulance.setHospitalName(ambulanceDTO.getHospitalName());
        ambulance.setLocation(ambulanceDTO.getLocation());
        Ambulance savedAmbulance = ambulanceRepository.save(ambulance);
        return savedAmbulance;
    }
}
