package com.dinopark.dino_park.controller;

import com.dinopark.dino_park.entity.EnergyPlant;
import com.dinopark.dino_park.service.EnergyPlantService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/energy-plants")


public class EnergyPlantController {

    private final EnergyPlantService service;

    public EnergyPlantController(EnergyPlantService service){

        this.service = service;

    }

    @GetMapping
    public List<EnergyPlant> getAllPlants(){

        return service.getAllPlants();

    }

    @GetMapping("/{id}")
    public EnergyPlant getPlant(

            @PathVariable
            Long id

    ){

        return service.getPlantById(id);

    }

    @PostMapping
    public EnergyPlant createPlant(

            @RequestBody
            EnergyPlant plant

    ){

        return service.savePlant(plant);

    }

    @PutMapping("/{id}")
    public EnergyPlant updatePlant(

            @PathVariable
            Long id,

            @RequestBody
            EnergyPlant plant

    ){

        return service.updatePlant(id, plant);

    }

    @DeleteMapping("/{id}")
    public void deletePlant(

            @PathVariable
            Long id

    ){

        service.deletePlant(id);
    }
    @PostMapping("/{id}/consume")
    public EnergyPlant consumeEnergy(

            @PathVariable
            Long id,

            @RequestParam
            Integer amount

    ){

        return service.consumeEnergy(id, amount);
    }

    @PostMapping("/{id}/restore")
    public EnergyPlant restoreEnergy(

            @PathVariable
            Long id,

            @RequestParam
            Integer amount

    ){

        return service.restoreEnergy(id, amount);
    }
}
