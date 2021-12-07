package com.epam.testproject.model;

import com.epam.testproject.enums.CarModel;

public class Car {

    private String carNumber;
    private CarModel carModel;
    private String name;
    private String color;

    public Car(Builder builder) {
        this.carNumber = builder.carNumber;
        this.carModel = builder.carModel;
        this.name = builder.name;
        this.color = builder.color;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public String getModel() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public static class Builder {
        private final String carNumber;
        private CarModel carModel;
        private final String name;
        private String color;

        public Builder(String carNumber, CarModel carModel, String name) {
            this.carNumber = carNumber;
            this.carModel = carModel;
            this.name = name;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "carNumber='" + carNumber + '\'' +
                ", carModel=" + carModel +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
