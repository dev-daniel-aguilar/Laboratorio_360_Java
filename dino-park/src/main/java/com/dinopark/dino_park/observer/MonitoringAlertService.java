package com.dinopark.dino_park.observer;

import org.springframework.stereotype.Service;

@Service
public class MonitoringAlertService
        implements ParkObserver {

    @Override
    public void update(String message){

        System.out.println("MONITOR ALERT: " + message);
    }

}