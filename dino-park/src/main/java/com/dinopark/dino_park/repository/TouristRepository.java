package com.dinopark.dino_park.repository;

import com.dinopark.dino_park.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristRepository extends JpaRepository<Tourist, Long> {

}
