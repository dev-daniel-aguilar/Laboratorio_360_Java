package com.dinopark.dino_park.service;

import com.dinopark.dino_park.entity.EnergyPlant;
import com.dinopark.dino_park.repository.EnergyPlantRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EnergyPlantServiceTest {

    private EnergyPlantRepository repository;
    private EnergyPlantService service;

    @BeforeEach
    void setUp(){

        repository = mock(
                EnergyPlantRepository.class
        );

        service = new EnergyPlantService(
                repository
        );

    }

    @Test
    void shouldConsumeEnergy(){

        EnergyPlant plant =
                EnergyPlant.builder()
                        .id(1L)
                        .currentEnergy(1000)
                        .maxCapacity(1000)
                        .status("ACTIVE")
                        .build();

        when(repository.findById(1L))
                .thenReturn(Optional.of(plant));

        when(repository.save(any(EnergyPlant.class)))
                .thenAnswer(invocation ->
                        invocation.getArgument(0)
                );

        EnergyPlant result =
                service.consumeEnergy(
                        1L,
                        300
                );

        assertEquals(
                700,
                result.getCurrentEnergy()
        );

        assertEquals(
                "ACTIVE",
                result.getStatus()
        );

        verify(repository).save(plant);

    }

    @Test
    void shouldSetLowPowerWhenEnergyIsBelowLimit(){

        EnergyPlant plant =
                EnergyPlant.builder()
                        .id(1L)
                        .currentEnergy(300)
                        .maxCapacity(1000)
                        .status("ACTIVE")
                        .build();

        when(repository.findById(1L))
                .thenReturn(Optional.of(plant));

        when(repository.save(any(EnergyPlant.class)))
                .thenAnswer(invocation ->
                        invocation.getArgument(0)
                );

        EnergyPlant result =
                service.consumeEnergy(
                        1L,
                        150
                );

        assertEquals(
                150,
                result.getCurrentEnergy()
        );

        assertEquals(
                "LOW_POWER",
                result.getStatus()
        );

    }

    @Test
    void shouldNotConsumeBelowZero(){

        EnergyPlant plant =
                EnergyPlant.builder()
                        .id(1L)
                        .currentEnergy(100)
                        .maxCapacity(1000)
                        .status("ACTIVE")
                        .build();

        when(repository.findById(1L))
                .thenReturn(Optional.of(plant));

        when(repository.save(any(EnergyPlant.class)))
                .thenAnswer(invocation ->
                        invocation.getArgument(0)
                );

        EnergyPlant result =
                service.consumeEnergy(
                        1L,
                        500
                );

        assertEquals(
                0,
                result.getCurrentEnergy()
        );

    }

}