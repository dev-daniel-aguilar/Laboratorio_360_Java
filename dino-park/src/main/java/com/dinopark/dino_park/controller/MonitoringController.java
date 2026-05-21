package com.dinopark.dino_park.controller;

import com.dinopark.dino_park.dto.ParkStatusResponse;
import com.dinopark.dino_park.service.MonitoringService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/monitoring")

public class MonitoringController {

    private final MonitoringService service;

    public MonitoringController(
            MonitoringService service
    ){

        this.service = service;

    }

    @GetMapping("/status")
    public ParkStatusResponse getStatus(){

        return service.getParkStatus();

    }

}