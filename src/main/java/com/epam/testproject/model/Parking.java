package com.epam.testproject.model;

public class Parking {

    private Integer id;
    private Integer entranceIndex;
    private Integer spotIndex;
    private Car car;
    private Long enteredTime;
    private Long leftTime;

    public Parking(Builder builder) {
        this.id = builder.id;
        this.entranceIndex = builder.entranceIndex;
        this.spotIndex = builder.spotIndex;
        this.car = builder.car;
        this.enteredTime = builder.enteredTime;
        this.leftTime = builder.leftTime;
    }

    public Integer getId() {
        return id;
    }

    public Integer getEntranceIndex() {
        return entranceIndex;
    }

    public Integer getSpotIndex() {
        return spotIndex;
    }

    public Car getCar() {
        return car;
    }

    public Long getEnteredTime() {
        return enteredTime;
    }

    public Long getLeftTime() {
        return leftTime;
    }

    public void setLeftTime() {
        this.leftTime = System.currentTimeMillis();
    }

    public static class Builder {
        private final Integer id;
        private final Integer spotIndex;
        private final Car car;
        private Integer entranceIndex;
        private Long enteredTime = System.currentTimeMillis();
        private Long leftTime;

        public Builder(Integer id, Integer spotIndex, Car car) {
            this.id = id;
            this.spotIndex = spotIndex;
            this.car = car;
        }

        public Builder entrance(Integer entranceIndex) {
            this.entranceIndex = entranceIndex;
            return this;
        }

        public Parking build() {
            return new Parking(this);
        }
    }
}
