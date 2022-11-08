package org.codesquad.maze;

import java.util.Stack;

public class QuestAlgorithm {

    private final int[][] map;
    private final Stack<Coordinate> route;
    private boolean[][] visitHistory;

    public QuestAlgorithm(int[][] map) {
        this.map = map;
        this.visitHistory = new boolean[map[0].length][map.length];
        this.route = new Stack<>();
    }

    public Stack<Coordinate> run() {
        init();

        while(isExit()) {
            quest();
        }

        return route;
    }

    private void init() {
        route.push(new Coordinate(0, 0));
        visitHistory[0][0] = true;
    }

    private boolean isExit() {
        Coordinate coordinate = route.peek();
        int[] position = coordinate.show();

        if (position[0] == map.length - 1 && position[1] == map.length - 1) {
            return false;
        }

        return true;
    }

    private void quest() {
        Coordinate coordinate = route.peek();
        int[] directionX = {1, -1, 0, 0};
        int[] directionY = {0, 0, 1, -1};
        int x = coordinate.show()[0];
        int y = coordinate.show()[1];

        for (int index = 0; index < directionX.length; index++) {
            int questX = x + directionX[index];
            int questY = y + directionY[index];

            if (Coordinate.isValid(questX, questY, map) && !visitHistory[questY][questX]) {
                visitHistory[questY][questX] = true;
                route.push(new Coordinate(questX, questY));
                return;
            }
        }

        route.pop();
    }
}