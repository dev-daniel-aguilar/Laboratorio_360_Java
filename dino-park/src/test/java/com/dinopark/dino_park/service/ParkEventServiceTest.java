package com.dinopark.dino_park.service;

import com.dinopark.dino_park.entity.ParkEvent;
import com.dinopark.dino_park.event.EventType;
import com.dinopark.dino_park.event.ParkEventFactory;
import com.dinopark.dino_park.observer.MonitoringAlertService;
import com.dinopark.dino_park.observer.ParkNotificationService;
import com.dinopark.dino_park.repository.ParkEventRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ParkEventServiceTest {

    private ParkEventRepository repository;
    private EnergyPlantService energyPlantService;
    private ParkEventFactory eventFactory;
    private ParkNotificationService notificationService;
    private MonitoringAlertService monitoringAlertService;

    private ParkEventService service;

    @BeforeEach
    void setUp(){

        repository = mock(ParkEventRepository.class);
        energyPlantService = mock(EnergyPlantService.class);
        eventFactory = mock(ParkEventFactory.class);
        notificationService = mock(ParkNotificationService.class);
        monitoringAlertService = mock(MonitoringAlertService.class);

        service = new ParkEventService(
                repository,
                energyPlantService,
                eventFactory,
                notificationService,
                monitoringAlertService
        );

    }

    @Test
    void shouldCreateBlackoutEvent(){

        ParkEvent blackout =
                ParkEvent.builder()
                        .id(1L)
                        .eventType("BLACKOUT")
                        .description("Massive blackout in the park")
                        .active(true)
                        .createdAt(LocalDateTime.now())
                        .build();

        when(eventFactory.createEvent(EventType.BLACKOUT))
                .thenReturn(blackout);

        when(repository.save(blackout))
                .thenReturn(blackout);

        ParkEvent result =
                service.createBlackoutEvent(1L);

        assertEquals(
                "BLACKOUT",
                result.getEventType()
        );

        assertTrue(
                result.getActive()
        );

        verify(energyPlantService)
                .consumeEnergy(1L, 500);

        verify(eventFactory)
                .createEvent(EventType.BLACKOUT);

        verify(notificationService)
                .notifyObservers(
                        "BLACKOUT event triggered"
                );

        verify(repository)
                .save(blackout);

    }

}