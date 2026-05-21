package com.dinopark.dino_park.service;

import com.dinopark.dino_park.entity.Zone;
import com.dinopark.dino_park.repository.ZoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneService {

    private final ZoneRepository repository;

    public ZoneService(ZoneRepository repository){

        this.repository = repository;

    }

    public List<Zone> getAllZones(){

        return repository.findAll();

    }

    public Zone saveZone(
            Zone zone
    ){

        return repository.save(zone);

    }

}
