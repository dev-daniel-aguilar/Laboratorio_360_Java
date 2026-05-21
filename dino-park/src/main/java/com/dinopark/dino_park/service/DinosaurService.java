package com.dinopark.dino_park.service;

import com.dinopark.dino_park.entity.Dinosaur;
import com.dinopark.dino_park.repository.DinosaurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DinosaurService {
    private final DinosaurRepository repository;

    public DinosaurService(
            DinosaurRepository repository
    ) {

        this.repository = repository;

    }

    public List<Dinosaur> getAllDinosaurs() {

        return repository.findAll();

    }

    public Dinosaur saveDinosaur(
            Dinosaur dinosaur
    ) {

        return repository.save(dinosaur);

    }
}
