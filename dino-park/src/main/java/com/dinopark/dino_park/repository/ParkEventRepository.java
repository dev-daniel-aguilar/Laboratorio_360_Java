package com.dinopark.dino_park.repository;

import com.dinopark.dino_park.entity.ParkEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkEventRepository extends JpaRepository<ParkEvent, Long> {
    Long countByActiveTrue();
}