package com.dinopark.dino_park.service;

import com.dinopark.dino_park.entity.EnergyPlant;
import com.dinopark.dino_park.entity.ParkEvent;
import com.dinopark.dino_park.repository.ParkEventRepository;
import com.dinopark.dino_park.event.EventType;
import com.dinopark.dino_park.event.ParkEventFactory;
import com.dinopark.dino_park.observer.ParkNotificationService;
import com.dinopark.dino_park.observer.MonitoringAlertService;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class ParkEventService {

    private final ParkEventRepository repository;

    private final EnergyPlantService energyPlantService;

    private final ParkEventFactory eventFactory;

    private final ParkNotificationService notificationService;

    private final MonitoringAlertService monitoringAlertService;

    public ParkEventService(ParkEventRepository repository, EnergyPlantService energyPlantService, ParkEventFactory eventFactory, ParkNotificationService notificationService, MonitoringAlertService
            monitoringAlertService){

        this.repository = repository;

        this.energyPlantService = energyPlantService;

        this.eventFactory = eventFactory;

        this.notificationService = notificationService;

        this.monitoringAlertService = monitoringAlertService;

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

        ParkEvent event =
                eventFactory.createEvent(
                        EventType.BLACKOUT
                );
        notificationService.notifyObservers(
                "BLACKOUT event triggered"
        );
        return repository.save(event);

    }


    public ParkEvent createStormEvent(
            Long energyPlantId
    ){

        energyPlantService.consumeEnergy(energyPlantId, 300);

        ParkEvent event =
                eventFactory.createEvent(
                        EventType.STORM
                );
        notificationService.notifyObservers(
                "STORM event triggered"
        );
        return repository.save(event);

    }

    public ParkEvent createDinosaurEscapeEvent(){

        ParkEvent event =
                eventFactory.createEvent(
                        EventType.DINO_ESCAPE
                );
        notificationService.notifyObservers(
                "Dinosaur escape detected"
        );
        return repository.save(event);

    }

    public ParkEvent createVehicleFailureEvent(){

        ParkEvent event =
                eventFactory.createEvent(
                        EventType.VEHICLE_FAILURE
                );
        notificationService.notifyObservers(
                "VehicleFailure event triggered"
        );
        return repository.save(event);

    }

    public ParkEvent createDiscountHourEvent(){

        ParkEvent event =
                eventFactory.createEvent(
                        EventType.DISCOUNT_HOUR
                );
        notificationService.notifyObservers(
                "DiscountHour event triggered"
        );
        return repository.save(event);

    }



}