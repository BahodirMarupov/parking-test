package com.epam.testproject.service;

import com.epam.testproject.enums.Level;
import com.epam.testproject.model.Car;
import com.epam.testproject.model.Entrance;
import com.epam.testproject.model.Parking;
import com.epam.testproject.model.Spot;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ParkingLotService {

    public static List<Parking> parkings = new ArrayList<>();
    public static Integer parkingId = 0;

    public Parking enter(Level level, Car car) {
        Entrance entrance = Entrance.getEntrance(level).orElseThrow(() -> new NoSuchElementException("Entrance is not found in this level!"));
        Spot spot = Spot.getAvailableSpot(level).orElseThrow(() -> new NoSuchElementException("There is not available spot in this floor!"));

        Parking parking = new Parking.Builder(++parkingId, spot.getIndex(), car).entrance(entrance.getIndex()).build();

        parkings.add(parking);
        spot.makeClose();

        return parking;
    }

    public void leave(Integer parkingId) {
        Parking parking = parkings.stream().filter(p -> p.getId().equals(parkingId)).findFirst().orElseThrow(() -> new NoSuchElementException("Parking info is not found!"));

        Entrance.getEntrance(parking.getEntranceIndex()).orElseThrow(() -> new NoSuchElementException("Entrance is not found!"));
        Spot spot = Spot.getSpot(parking.getSpotIndex()).orElseThrow(() -> new NoSuchElementException("There is not available spot in this floor!"));

        parking.setLeftTime();
        spot.makeOpen();
    }
}
