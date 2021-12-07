package com.epam.testproject.model;

import com.epam.testproject.enums.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class Spot {

    private static List<Spot> spots = new ArrayList<>();

    private Integer index;
    private Boolean available;
    private Integer size;
    private Level level;

    static {
        spots.add(new Spot(1, 12, Level.FIRST));
        spots.add(new Spot(2, 12, Level.FIRST));
        spots.add(new Spot(3, 12, Level.FIRST));
        spots.add(new Spot(4, 12, Level.FIRST));
        spots.add(new Spot(5, 12, Level.FIRST));
        spots.add(new Spot(6, 12, Level.FIRST));
        spots.add(new Spot(7, 10, Level.SECOND));
        spots.add(new Spot(8, 10, Level.SECOND));
        spots.add(new Spot(9, 10, Level.SECOND));
        spots.add(new Spot(10, 10, Level.SECOND));
        spots.add(new Spot(11, 10, Level.SECOND));
        spots.add(new Spot(12, 14, Level.THIRD));
        spots.add(new Spot(13, 14, Level.THIRD));
        spots.add(new Spot(14, 14, Level.THIRD));
        spots.add(new Spot(15, 14, Level.THIRD));
        spots.add(new Spot(16, 14, Level.THIRD));
        spots.add(new Spot(17, 14, Level.THIRD));
        spots.add(new Spot(18, 14, Level.THIRD));
        spots.add(new Spot(19, 14, Level.THIRD));
    }

    private Spot(Integer index, Integer size, Level level) {
        this.index = index;
        this.size = size;
        this.level = level;
        this.available = true;
    }

    public Integer getIndex() {
        return index;
    }

    public Boolean getAvailable() {
        return available;
    }

    public Level getLevel() {
        return level;
    }

    public Integer getSize() {
        return size;
    }

    public void makeClose() {
        this.available = false;
    }

    public void makeOpen() {
        this.available = true;
    }

    public static Optional<Spot> getSpot(Integer index) {
        return spots.stream().filter(spot -> spot.index.equals(index)).findFirst();
    }

    public static Optional<Spot> getAvailableSpot(Level level) {
        return spots.stream().filter(spot -> spot.level.equals(level) && spot.available).findAny();
    }

    public static List<Spot> getSpots(Level level) {
        return spots.stream().filter(spot -> spot.level.equals(level)).collect(Collectors.toList());
    }

}
