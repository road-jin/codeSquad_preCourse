package org.codesquad.rectangle;

public class Rectangle {

    private final Integer x;
    private final Integer y;
    private final Integer width;
    private final Integer height;

    public Rectangle(Integer x, Integer y, Integer width, Integer height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int square() {
        return width * height;
    }

    public void show() {
        System.out.printf("(%d,%d)에서 크키가 %dx%d인 사각형\n", x, y, width, height);
    }

    public boolean contains(Rectangle r) {
        if ((x + width) > (r.x + r.width) &&  (y + height) > (r.y + r.height)) {
            return true;
        }

        return false;
    }
}
