package org.codesquad.maze;

import java.util.Arrays;
import java.util.Stack;

public class Maze {

    private int[][] map = {
            {0, 0, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 0}
    };

    public void findExit() {
        QuestAlgorithm dfs = new QuestAlgorithm(map);
        print(dfs.run());
    }

    private void print(Stack<Coordinate> route) {
        printMap();
        printRoute(route);
    }

    private void printMap() {
        System.out.printf("출구는 (%d,%d) 입니다.\n", map[0].length - 1, map.length - 1);

        Arrays.stream(map).forEach(ints -> {
            Arrays.stream(ints)
                    .forEach(road -> System.out.print(road));
            System.out.println();
        });
    }

    private void printRoute(Stack<Coordinate> route) {
        StringBuilder log = new StringBuilder();
        appendLog(log,  route.pop(), "");

        while(!route.isEmpty()) {
            appendLog(log,  route.pop(), " <- ");
        }

        System.out.println(log);
    }

    private void appendLog(StringBuilder log, Coordinate coordinate, String FirstText) {
        int[] position = coordinate.show();
        log.append(FirstText + "(" + position[0] + "," + position[1] + ")");
    }
}
