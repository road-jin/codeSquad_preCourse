package org.codesquad.maze;

import java.util.Stack;

public class Maze {

    private int[][] map = {
            {1, 0, 0, 0, 1, 0, 0, 0},
            {1, 1, 1, 0, 1, 1, 1, 1},
            {0, 0, 1, 1, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 0, 1, 0},
            {0, 1, 1, 0, 1, 1, 1, 1},
            {1, 0, 0, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 1, 1},
            {1, 0, 0, 1, 0, 0, 0, 1}
    };
    private Coordinate preCoordinate;

    public void findExit() {
        Bfs bfs = new Bfs();
        print(bfs.run(map));
    }

    private void print(Stack<Coordinate> route) {
        StringBuilder log = new StringBuilder();
        preCoordinate = route.pop();
        log.append(preCoordinate.show());

        while(!route.isEmpty()) {
            Coordinate coordinate = route.pop();
            appendLog(coordinate, log);
        }

        System.out.println(log);
    }

    private void appendLog(Coordinate coordinate, StringBuilder log) {
        if (preCoordinate.isPrevious(coordinate)) {
            log.append(" <- " + coordinate.show());
            preCoordinate = coordinate;
        }
    }
}
