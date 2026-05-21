package com.dinopark.dino_park.controller;

import com.dinopark.dino_park.entity.Zone;
import com.dinopark.dino_park.service.ZoneService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zones")

public class ZoneController {

    private final ZoneService service;

    public ZoneController(ZoneService service){

        this.service = service;

    }

    @GetMapping
    public List<Zone> getAllZones(){

        return service.getAllZones();

    }

    @PostMapping
    public Zone createZone(

            @RequestBody
            Zone zone

    ){

        return service.saveZone(
                zone
        );

    }

}
