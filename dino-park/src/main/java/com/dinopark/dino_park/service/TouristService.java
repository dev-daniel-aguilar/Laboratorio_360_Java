package com.dinopark.dino_park.service;

import com.dinopark.dino_park.entity.Tourist;
import com.dinopark.dino_park.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {

    private final TouristRepository repository;

    public TouristService(
            TouristRepository repository
    ){

        this.repository = repository;

    }

    public List<Tourist> getAllTourists(){

        return repository.findAll();

    }

    public Tourist saveTourist(
            Tourist tourist
    ){

        return repository.save(
                tourist
        );

    }

    public Tourist getTouristById(Long id){

        return repository.findById(id).orElseThrow(() -> new RuntimeException("Tourist not found"));

    }

    public Tourist updateTourist(Long id, Tourist updatedTourist){

        Tourist tourist = getTouristById(id);

        tourist.setFullName(
                updatedTourist.getFullName()
        );

        tourist.setAge(
                updatedTourist.getAge()
        );

        tourist.setTicketType(
                updatedTourist.getTicketType()
        );

        tourist.setInsidePark(
                updatedTourist.getInsidePark()
        );

        return repository.save(
                tourist
        );

    }

    public void deleteTourist(
            Long id
    ){

        repository.deleteById(id);

    }

}
