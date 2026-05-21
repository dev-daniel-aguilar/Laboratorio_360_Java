package com.dinopark.dino_park.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name="zone")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private Integer currentVisitors;

    @Column(nullable = false)
    private Boolean active;

    //Zone -> lista turistas
    @OneToMany(mappedBy="zone")
    private List<Tourist> tourists;
}
