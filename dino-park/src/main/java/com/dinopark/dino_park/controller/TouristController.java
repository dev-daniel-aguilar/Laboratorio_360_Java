package com.dinopark.dino_park.controller;

import com.dinopark.dino_park.entity.Tourist;
import com.dinopark.dino_park.service.TouristService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tourists")

public class TouristController {

    private final TouristService service;

    public TouristController(TouristService service){

        this.service = service;

    }

    @GetMapping
    public List<Tourist> getAllTourists(){

        return service.getAllTourists();

    }

    @GetMapping("/{id}")
    public Tourist getById(

            @PathVariable
            Long id

    ){

        return service
                .getTouristById(id);

    }

    @PostMapping
    public Tourist createTourist(

            @RequestBody
            Tourist tourist

    ){

        return service
                .saveTourist(tourist);

    }

    @PutMapping("/{id}")
    public Tourist updateTourist(

            @PathVariable
            Long id,

            @RequestBody
            Tourist tourist

    ){

        return service
                .updateTourist(
                        id,
                        tourist
                );

    }

    @DeleteMapping("/{id}")
    public void deleteTourist(

            @PathVariable
            Long id

    ){

        service.deleteTourist(id);

    }
}
