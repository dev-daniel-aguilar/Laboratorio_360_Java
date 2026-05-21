package com.dinopark.dino_park.observer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkNotificationService {

    private final List<ParkObserver>
            observers =
            new ArrayList<>();

    public void addObserver(
            ParkObserver observer
    ){

        observers.add(observer);

    }

    public void notifyObservers(String message){

        for(ParkObserver observer
                : observers){

            observer.update(
                    message
            );

        }

    }

}