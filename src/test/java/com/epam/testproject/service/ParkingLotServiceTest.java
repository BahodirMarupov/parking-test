package com.epam.testproject.service;

import com.epam.testproject.enums.Level;
import com.epam.testproject.model.Car;
import com.epam.testproject.model.Parking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import static com.epam.testproject.enums.CarModel.*;
import static com.epam.testproject.enums.Level.*;
import static java.util.concurrent.CompletableFuture.runAsync;

class ParkingLotServiceTest {

    private List<Car> cars = new ArrayList<>();
    private ParkingLotService parkingLotService = new ParkingLotService();

    @BeforeEach
    void setCars() {
        cars.add(new Car.Builder("AB123", CHEVROLET, "Nexia").color("clack").build());
        cars.add(new Car.Builder("AB123", CHEVROLET, "Nexia").color("Red").build());
        cars.add(new Car.Builder("AB123", CHEVROLET, "Nexia").build());
        cars.add(new Car.Builder("AB133", CHEVROLET, "Lacetti").build());
        cars.add(new Car.Builder("AB123", CHEVROLET, "Lacetti").build());
        cars.add(new Car.Builder("AB123", CHEVROLET, "Lacetti").build());
        cars.add(new Car.Builder("AB123", CHEVROLET, "Lacetti").build());
        cars.add(new Car.Builder("AB123", CHEVROLET, "Malubu").build());
        cars.add(new Car.Builder("AB123", CHEVROLET, "Malubu").build());
        cars.add(new Car.Builder("AB123", BMW, "Nexia").build());
        cars.add(new Car.Builder("AB123", BMW, "Nexia").build());
        cars.add(new Car.Builder("AB123", BMW, "Nexia").build());
        cars.add(new Car.Builder("AB123", BMW, "Nexia").build());
        cars.add(new Car.Builder("AB123", MERCEDES, "MERCEDES").build());
        cars.add(new Car.Builder("AB123", MERCEDES, "MERCEDES").build());
        cars.add(new Car.Builder("AB123", MERCEDES, "MERCEDES").build());
        cars.add(new Car.Builder("AB123", MERCEDES, "MERCEDES").build());
        cars.add(new Car.Builder("AB123", MUSTANG, "MUSTANG").build());
        cars.add(new Car.Builder("AB123", MUSTANG, "MUSTANG").build());
        cars.add(new Car.Builder("AB123", MUSTANG, "MUSTANG").build());
        cars.add(new Car.Builder("AB123", MUSTANG, "MUSTANG").build());
        cars.add(new Car.Builder("AB123", MUSTANG, "MUSTANG").build());
        cars.add(new Car.Builder("AB123", MUSTANG, "MUSTANG").build());
        cars.add(new Car.Builder("AB123", MUSTANG, "MUSTANG").build());
        cars.add(new Car.Builder("AB123", MUSTANG, "MUSTANG").build());
        cars.add(new Car.Builder("AB123", MUSTANG, "MUSTANG").build());
    }

    @Test
    public void testParking() {

        Level level = FIRST;
        for (int i = 0; i < cars.size(); i++) {
            try {
                level = getLevel(i);
                Parking parking = parkingLotService.enter(level, cars.get(i));
                System.out.println(i + " : entered");

                int finalI = i;
                runAsync(() -> putWaiting(parking.getId(), finalI));

            } catch (NoSuchElementException e) {
                System.out.println("#index: " + i + ", level: " + level.name() + "\n" + cars.get(i).toString() + "\n" + e.getMessage());
            }
        }
    }

    private void putWaiting(Integer parkingId, int i) {
        try {
            Thread.sleep(new Random().nextInt(10) * 1000);
            parkingLotService.leave(parkingId);
            System.out.println(i + " : left");

        } catch (NoSuchElementException e) {
            System.out.println("#index: " + i + "\n" + cars.get(i).toString() + "\n" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Level getLevel(int i) {
        switch (i % 3) {
            case 0:
                return FIRST;
            case 1:
                return SECOND;
            case 2:
                return THIRD;
            default:
                return FIRST;
        }
    }
}