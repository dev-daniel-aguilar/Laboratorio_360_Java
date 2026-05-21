package com.dinopark.dino_park.service;

import com.dinopark.dino_park.entity.EnergyPlant;
import com.dinopark.dino_park.repository.EnergyPlantRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnergyPlantService {

    private final EnergyPlantRepository repository;

    public EnergyPlantService(EnergyPlantRepository repository){

        this.repository = repository;

    }

    public List<EnergyPlant> getAllPlants(){

        return repository.findAll();
    }

    public EnergyPlant savePlant(
            EnergyPlant plant
    ){
        return repository.save(
                plant
        );
    }

    public EnergyPlant getPlantById(
            Long id
    ){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Plant not found"));
    }

    public EnergyPlant updatePlant(Long id, EnergyPlant updatedPlant){

        EnergyPlant plant =
                getPlantById(id);

        plant.setCurrentEnergy(
                updatedPlant.getCurrentEnergy()
        );

        plant.setMaxCapacity(
                updatedPlant.getMaxCapacity()
        );

        plant.setStatus(
                updatedPlant.getStatus()
        );

        return repository.save(
                plant
        );

    }

    public void deletePlant(
            Long id
    ){
        repository.deleteById(
                id
        );
    }

    public EnergyPlant consumeEnergy(Long id, Integer amount){
        EnergyPlant plant = getPlantById(id);

        Integer newEnergy = plant.getCurrentEnergy() - amount;

        if(newEnergy < 0){

            newEnergy = 0;

        }

        plant.setCurrentEnergy(
                newEnergy
        );

        Integer limit = plant.getMaxCapacity() / 5;

        if(newEnergy <= limit){

            plant.setStatus("LOW_POWER");

        }

        return repository.save(plant);
    }

    public EnergyPlant restoreEnergy(Long id, Integer amount){
        EnergyPlant plant = getPlantById(id);

        Integer newEnergy = plant.getCurrentEnergy() + amount;

        if(
                newEnergy > plant.getMaxCapacity()
        ){

            newEnergy = plant.getMaxCapacity();

        }

        plant.setCurrentEnergy(newEnergy);

        plant.setStatus("ACTIVE");

        return repository.save(plant);

    }
}

