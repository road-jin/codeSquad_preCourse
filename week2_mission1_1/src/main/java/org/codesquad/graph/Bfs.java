package org.codesquad.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    private final int[][] graph;
    private final boolean[] visited;
    private final Queue<Integer> queue;

    public Bfs(int[][] graph) {
        this.graph = graph;
        this.visited = new boolean[graph.length];
        this.queue = new LinkedList<>();
    }

    public void run() {
        init();

        while (!queue.isEmpty()) {
            quest();
        }

        System.out.println();
    }

    private void quest() {
        Integer poll = queue.poll();

        for (int i = 0; i < graph[poll].length; i++) {
            if (!visited[graph[poll][i]]) {
                queue.offer(graph[poll][i]);
                visited[graph[poll][i]] = true;
                System.out.print(graph[poll][i] + " ");
            }
        }
    }

    private void init() {
        queue.offer(0);
        visited[0] = true;
        System.out.print(0 + " ");
    }
}
