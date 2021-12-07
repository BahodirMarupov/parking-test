package com.epam.testproject.model;

import com.epam.testproject.enums.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Entrance {

    public static List<Entrance> entrances = new ArrayList<>();

    private Integer index;
    private Level level;

    static {
        entrances.add(new Entrance(1,Level.FIRST));
        entrances.add(new Entrance(2,Level.FIRST));
        entrances.add(new Entrance(3,Level.SECOND));
        entrances.add(new Entrance(4,Level.SECOND));
        entrances.add(new Entrance(5,Level.THIRD));
        entrances.add(new Entrance(6,Level.THIRD));
    }

    private Entrance(Integer index, Level level) {
        this.index = index;
        this.level = level;
    }

    public Integer getIndex() {
        return index;
    }

    public Level getLevel() {
        return level;
    }

    public static Optional<Entrance> getEntrance(Integer index) {
        return entrances.stream().filter(entrance -> entrance.getIndex().equals(index)).findFirst();
    }

    public static Optional<Entrance> getEntrance(Level level) {
        return entrances.stream().filter(entrance -> entrance.getLevel().equals(level)).findAny();
    }
}
