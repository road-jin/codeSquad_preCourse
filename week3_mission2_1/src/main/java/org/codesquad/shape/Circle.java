package org.codesquad.shape;

public class Circle implements Shape {

    private final int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.printf("반지름이 %d인 원입니다.\n", this.radius);
    }

    @Override
    public double getArea() {
        return this.radius * this.radius * this.PI;
    }

}
