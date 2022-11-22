package org.codesquad.shape;

public class Rect implements Shape {

    private final int length;
    private final int width;

    public Rect(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void draw() {
        System.out.printf("%dx%d크기의 사각형 입니다.\n", this.length, this.width);
    }

    @Override
    public double getArea() {
        return this.length * this.width;
    }
}
