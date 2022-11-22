package org.codesquad.shape;

public class Oval implements Shape {

    private final int shortRadius;
    private final int longRadius;

    public Oval(int shortRadius, int longRadius) {
        this.shortRadius = shortRadius;
        this.longRadius = longRadius;
    }

    @Override
    public void draw() {
        System.out.printf("%dx%d에 내접하는 타원입니다.\n", this.shortRadius, this.longRadius);
    }

    @Override
    public double getArea() {
        return this.longRadius * this.shortRadius * this.PI;
    }
}
