package org.codesquad.maze;

public class Coordinate {
    private final int x;
    private final int y;
    private final int preX;
    private final int preY;

    public Coordinate(int x, int y, int preX, int preY) {
        this.x = x;
        this.y = y;
        this.preX = preX;
        this.preY = preY;
    }

    public int[] xy() {
        return new int[] {x, y};
    }

    public String show() {
        return "(" + x + "," + y + ")";
    }

    public boolean isPrevious(Coordinate coordinate) {
        return preX == coordinate.x && preY == coordinate.y;
    }
}
