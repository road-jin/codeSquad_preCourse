package org.codesquad.maze;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class Bfs {
    private final Queue<int[]> queue;
    private final Stack<Coordinate> route;

    public Bfs() {
        this.queue = new LinkedList<>();
        this.route = new Stack<>();
    }

    public Stack<Coordinate> run(int[][] map) {
        boolean[][] visitHistory = new boolean[map[0].length][map.length];
        queue.offer(new int[]{0,0});

        while(!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            quest(map, visitHistory, coordinate);
        }

        return route;
    }

    private void quest(int[][] map, boolean[][] visitHistory, int[] coordinate) {
        int[] cardinalDirectionX = {1, -1, 0, 0};
        int[] cardinalDirectionY = {0, 0, 1, -1};
        int preX = coordinate[0];
        int preY = coordinate[1];
        AtomicInteger atomicInteger = new AtomicInteger();

        Arrays.stream(cardinalDirectionX)
                .forEach((i) -> {
                    int index = atomicInteger.getAndIncrement();
                    int x = preX + cardinalDirectionX[index];
                    int y = preY + cardinalDirectionY[index];

                    if ((x >= 0 && x < map.length) &&
                            (y >= 0 && y < map.length)) {
                        int result = map[y][x];
                        queuePush(visitHistory, new Coordinate(x, y, preX, preY), result);
                    }
        });
    }

    private void queuePush(boolean[][] visitHistory, Coordinate coordinate, int result) {
        int x = coordinate.xy()[0];
        int y = coordinate.xy()[1];

        if (result == 1 && visitHistory[y][x] == false) {
            visitHistory[y][x] = true;
            route.push(coordinate);
            queue.offer(new int[]{x, y});
        }
    }
}
