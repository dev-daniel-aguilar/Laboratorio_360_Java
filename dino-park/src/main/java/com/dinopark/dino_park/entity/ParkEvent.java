package com.dinopark.dino_park.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="park_event")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ParkEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String eventType;

    @Column(nullable=false)
    private String description;

    @Column(nullable=false)
    private Boolean active;

    @Column(nullable=false)
    private LocalDateTime createdAt;

}