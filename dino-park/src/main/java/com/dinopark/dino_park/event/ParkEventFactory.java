package com.dinopark.dino_park.event;

import com.dinopark.dino_park.entity.ParkEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ParkEventFactory {

    public ParkEvent createEvent(
            EventType eventType
    ){

        return switch(eventType){

            case BLACKOUT ->
                    build(
                            "BLACKOUT",
                            "Massive blackout in the park"
                    );

            case STORM ->
                    build(
                            "STORM",
                            "Torrential storm affected park operations"
                    );

            case DINO_ESCAPE ->
                    build(
                            "DINO_ESCAPE",
                            "A dinosaur escaped from its enclosure"
                    );

            case VEHICLE_FAILURE ->
                    build(
                            "VEHICLE_FAILURE",
                            "A vehicle failed during park operations"
                    );

            case DISCOUNT_HOUR ->
                    build(
                            "DISCOUNT_HOUR",
                            "Discount hour activated for visitors"
                    );

        };

    }

    private ParkEvent build(
            String eventType,
            String description
    ){

        return ParkEvent.builder()
                .eventType(eventType)
                .description(description)
                .active(true)
                .createdAt(LocalDateTime.now())
                .build();

    }

}