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

        return buildEvent(
                "BLACKOUT",
                "Massive blackout in the park"
        );

    }

    private ParkEvent buildEvent(String eventType, String description){

        ParkEvent event =
                ParkEvent.builder()
                        .eventType(eventType)
                        .description(description)
                        .active(true)
                        .createdAt(
                                LocalDateTime.now()
                        )
                        .build();

        return repository.save(event);

    }

    public ParkEvent createStormEvent(
            Long energyPlantId
    ){

        energyPlantService.consumeEnergy(energyPlantId, 300);

        return buildEvent(
                "STORM",
                "Torrential storm affected park operations"
        );

    }

    public ParkEvent createDinosaurEscapeEvent(){

        return buildEvent(
                "DINO_ESCAPE",
                "A dinosaur escaped from its enclosure"
        );

    }

    public ParkEvent createVehicleFailureEvent(){

        return buildEvent(
                "VEHICLE_FAILURE",
                "A vehicle failed during park operations"
        );

    }

    public ParkEvent createDiscountHourEvent(){

        return buildEvent(
                "DISCOUNT_HOUR",
                "Discount hour activated for visitors"
        );

    }

}