package com.dinopark.dino_park.scheduler;

import com.dinopark.dino_park.service.ParkEventService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomEventScheduler {

    private final ParkEventService parkEventService;
    private final Random random = new Random();

    public RandomEventScheduler(
            ParkEventService parkEventService
    ){
        this.parkEventService = parkEventService;
    }

    @Scheduled(fixedRate = 30000)
    public void generateRandomEvent(){

        int eventNumber =
                random.nextInt(5);

        Long energyPlantId = 1L;

        switch(eventNumber){

            case 0 ->
                    parkEventService
                            .createBlackoutEvent(
                                    energyPlantId
                            );

            case 1 ->
                    parkEventService
                            .createStormEvent(
                                    energyPlantId
                            );

            case 2 ->
                    parkEventService
                            .createDinosaurEscapeEvent();

            case 3 ->
                    parkEventService
                            .createVehicleFailureEvent();

            case 4 ->
                    parkEventService
                            .createDiscountHourEvent();

            default ->
                    throw new IllegalStateException(
                            "Unexpected event number"
                    );
        }

    }

}