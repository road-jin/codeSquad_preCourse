package org.codesquad.factory;

public class HyundaiFactory {

    private static HyundaiFactory factory = new HyundaiFactory();
    private int carNumberCount = 1000;

    private HyundaiFactory() {

    }

    public static HyundaiFactory getFactory() {
        return factory;
    }

    public Car createCar() {
        return new Car(carNumberCount++);
    }
}
