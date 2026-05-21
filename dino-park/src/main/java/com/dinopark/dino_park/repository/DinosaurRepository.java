package com.dinopark.dino_park.repository;

import com.dinopark.dino_park.entity.Dinosaur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DinosaurRepository
        extends JpaRepository<Dinosaur, Long> {

}
