package org.codesquad.point;

public class PositivePoint extends Point {

    public PositivePoint() {
        super(0, 0);
    }

    public PositivePoint(int x, int y) {
        super(0, 0);
        notMoveMinusPosition(x, y);
    }

    private void notMoveMinusPosition(int x, int y) {
        if (x >= 0 && y >= 0) {
            super.move(x, y);
        }
    }

    @Override
    public void move(int x, int y) {
        notMoveMinusPosition(x, y);
    }

    @Override
    public String toString() {
        return "(" + super.getX() + "," + super.getY() + ")" + "의 점";
    }
}
