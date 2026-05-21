package com.dinopark.dino_park.controller;

import com.dinopark.dino_park.entity.Dinosaur;
import com.dinopark.dino_park.service.DinosaurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dinosaurs")


public class DinosaurController {
    private final DinosaurService service;

    public DinosaurController(
            DinosaurService service
    ){

        this.service = service;

    }

    @GetMapping

    public List<Dinosaur> getAllDinosaurs(){

        return service.getAllDinosaurs();

    }

    @PostMapping

    public Dinosaur createDinosaur(

            @RequestBody
            Dinosaur dinosaur

    ){

        return service.saveDinosaur(
                dinosaur
        );

    }
}
