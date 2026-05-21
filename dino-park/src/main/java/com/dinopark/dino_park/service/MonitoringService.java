package com.dinopark.dino_park.service;

import com.dinopark.dino_park.dto.ParkStatusResponse;
import com.dinopark.dino_park.entity.EnergyPlant;
import com.dinopark.dino_park.repository.*;

import org.springframework.stereotype.Service;

@Service
public class MonitoringService {

    private final TouristRepository touristRepository;

    private final DinosaurRepository dinosaurRepository;

    private final ZoneRepository zoneRepository;

    private final ParkEventRepository parkEventRepository;

    private final EnergyPlantRepository energyPlantRepository;

    public MonitoringService(

            TouristRepository touristRepository,

            DinosaurRepository dinosaurRepository,

            ZoneRepository zoneRepository,

            ParkEventRepository parkEventRepository,

            EnergyPlantRepository energyPlantRepository

    ){

        this.touristRepository = touristRepository;

        this.dinosaurRepository = dinosaurRepository;

        this.zoneRepository = zoneRepository;

        this.parkEventRepository = parkEventRepository;

        this.energyPlantRepository = energyPlantRepository;

    }

    public ParkStatusResponse getParkStatus(){

        Integer totalEnergy = energyPlantRepository.findAll()
                        .stream()
                        .mapToInt(
                                EnergyPlant::getCurrentEnergy
                        )
                        .sum();

        return ParkStatusResponse.builder()
                .activeTourists(
                        touristRepository
                                .countByInsideParkTrue()
                )
                .totalDinosaurs(
                        dinosaurRepository.count()
                )
                .activeZones(
                        zoneRepository.countByActiveTrue()
                )
                .activeEvents(
                        parkEventRepository.countByActiveTrue()
                )
                .totalEnergyAvailable(
                        totalEnergy
                )
                .build();

    }

}