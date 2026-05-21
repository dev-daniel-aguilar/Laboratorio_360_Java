package com.dinopark.dino_park.service;

import com.dinopark.dino_park.dto.ParkStatusResponse;
import com.dinopark.dino_park.entity.EnergyPlant;
import com.dinopark.dino_park.repository.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MonitoringServiceTest {

    private TouristRepository touristRepository;
    private DinosaurRepository dinosaurRepository;
    private ZoneRepository zoneRepository;
    private ParkEventRepository parkEventRepository;
    private EnergyPlantRepository energyPlantRepository;

    private MonitoringService service;

    @BeforeEach
    void setUp(){

        touristRepository = mock(TouristRepository.class);
        dinosaurRepository = mock(DinosaurRepository.class);
        zoneRepository = mock(ZoneRepository.class);
        parkEventRepository = mock(ParkEventRepository.class);
        energyPlantRepository = mock(EnergyPlantRepository.class);

        service = new MonitoringService(
                touristRepository,
                dinosaurRepository,
                zoneRepository,
                parkEventRepository,
                energyPlantRepository
        );

    }

    @Test
    void shouldReturnParkStatus(){

        EnergyPlant plantOne =
                EnergyPlant.builder()
                        .id(1L)
                        .currentEnergy(350)
                        .maxCapacity(1000)
                        .status("LOW_POWER")
                        .build();

        EnergyPlant plantTwo =
                EnergyPlant.builder()
                        .id(2L)
                        .currentEnergy(500)
                        .maxCapacity(1000)
                        .status("ACTIVE")
                        .build();

        when(touristRepository.countByInsideParkTrue())
                .thenReturn(3L);

        when(dinosaurRepository.count())
                .thenReturn(5L);

        when(zoneRepository.countByActiveTrue())
                .thenReturn(2L);

        when(parkEventRepository.countByActiveTrue())
                .thenReturn(4L);

        when(energyPlantRepository.findAll())
                .thenReturn(
                        List.of(
                                plantOne,
                                plantTwo
                        )
                );

        ParkStatusResponse result =
                service.getParkStatus();

        assertEquals(3L, result.getActiveTourists());
        assertEquals(5L, result.getTotalDinosaurs());
        assertEquals(2L, result.getActiveZones());
        assertEquals(4L, result.getActiveEvents());
        assertEquals(850, result.getTotalEnergyAvailable());

    }

}