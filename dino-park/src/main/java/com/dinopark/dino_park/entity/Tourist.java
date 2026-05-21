package com.dinopark.dino_park.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tourist")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable=false)
    private String fullName;

    @Column(nullable=false)
    private Integer age;

    @Column(nullable=false)
    private String ticketType;

    @Column(nullable=false)
    private Boolean insidePark;
}
