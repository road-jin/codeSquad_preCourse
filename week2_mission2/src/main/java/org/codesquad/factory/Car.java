package org.codesquad.factory;

public class Car {
    private final int carNumber;

    public Car(int carNumber) {
        this.carNumber = carNumber;
    }

    public int showCarNumber() {
        return carNumber;
    }
}
