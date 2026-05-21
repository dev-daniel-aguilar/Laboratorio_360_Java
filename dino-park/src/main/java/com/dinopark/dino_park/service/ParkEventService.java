package com.dinopark.dino_park.service;

import com.dinopark.dino_park.entity.EnergyPlant;
import com.dinopark.dino_park.entity.ParkEvent;
import com.dinopark.dino_park.repository.ParkEventRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class ParkEventService {

    private final ParkEventRepository repository;

    private final EnergyPlantService energyPlantService;

    public ParkEventService(ParkEventRepository repository, EnergyPlantService energyPlantService){

        this.repository = repository;

        this.energyPlantService =
                energyPlantService;

    }

    public List<ParkEvent> getAllEvents(){

        return repository.findAll();

    }

    public ParkEvent saveEvent(ParkEvent event){

        return repository.save(
                event
        );

    }

    public ParkEvent createBlackoutEvent(

            Long energyPlantId

    ){

        energyPlantService.consumeEnergy(energyPlantId, 500);

        ParkEvent event = ParkEvent.builder().eventType("BLACKOUT").description("Massive blackout in the park").active(true).createdAt(LocalDateTime.now()).build();

        return repository.save(
                event
        );

    }

}