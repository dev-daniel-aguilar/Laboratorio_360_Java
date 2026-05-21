package com.dinopark.dino_park.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dinosaur")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dinosaur {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private Boolean carnivore;

    @Column(nullable = false)
    private Integer energy;

}
