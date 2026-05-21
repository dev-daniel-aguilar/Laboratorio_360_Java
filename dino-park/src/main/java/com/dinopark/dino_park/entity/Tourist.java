package com.dinopark.dino_park.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    //Muchos touristas a una zona
    @ManyToOne

    @JoinColumn(name="zone_id")

    @JsonIgnoreProperties("tourists")

    private Zone zone;
}
