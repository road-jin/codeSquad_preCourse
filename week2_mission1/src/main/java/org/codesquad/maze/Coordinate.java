package org.codesquad.maze;

public class Coordinate {

    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int[] show() {
        return new int[] {x, y};
    }

    public static boolean isValid(int x, int y, int[][] map) {
        if ((x >= 0 && x < map[0].length) &&
                (y >= 0 && y < map.length) && map[y][x] == 0) {
            return true;
        }

        return false;
    }
}
