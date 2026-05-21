package com.dinopark.dino_park.controller;

import com.dinopark.dino_park.entity.ParkEvent;
import com.dinopark.dino_park.service.ParkEventService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")

public class ParkEventController {

    private final ParkEventService service;

    public ParkEventController(ParkEventService service){

        this.service = service;

    }

    @GetMapping
    public List<ParkEvent> getAllEvents(){

        return service.getAllEvents();

    }

    @PostMapping("/blackout")
    public ParkEvent createBlackout(

            @RequestParam
            Long energyPlantId

    ){

        return service.createBlackoutEvent(energyPlantId);
    }

}