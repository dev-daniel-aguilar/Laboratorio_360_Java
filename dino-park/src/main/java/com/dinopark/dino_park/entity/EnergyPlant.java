package com.dinopark.dino_park.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="energy_plant")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EnergyPlant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private Integer currentEnergy;

    @Column(nullable=false)
    private Integer maxCapacity;

    @Column(nullable=false)
    private String status;
}
