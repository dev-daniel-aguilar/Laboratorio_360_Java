package com.dinopark.dino_park.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ParkStatusResponse {

    private Long activeTourists;

    private Long totalDinosaurs;

    private Long activeZones;

    private Long activeEvents;

    private Integer totalEnergyAvailable;

}