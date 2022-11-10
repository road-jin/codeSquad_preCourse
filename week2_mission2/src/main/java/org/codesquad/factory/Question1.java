package org.codesquad.factory;

public class Question1 {

    public static void main(String[] args) {
        HyundaiFactory factory = HyundaiFactory.getFactory();
        Car myCar = factory.createCar();
        Car yourCar = factory.createCar();

        System.out.println("첫번째 차 번호는 " + myCar.showCarNumber());
        System.out.println("두번쨰 차 번호는 " + yourCar.showCarNumber());
    }
}
