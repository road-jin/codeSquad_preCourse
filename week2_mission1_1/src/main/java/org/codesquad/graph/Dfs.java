package org.codesquad.graph;

import java.util.Stack;

public class Dfs {

    private final int[][] grape;
    private final boolean[] visited;
    private final Stack<Integer> stack;

    public Dfs(int[][] grape) {
        this.grape = grape;
        this.visited = new boolean[grape.length];
        this.stack = new Stack<>();
    }

    public void run() {
        init();

        while(!stack.isEmpty()) {
            quest();
        }

        System.out.println();
    }

    private void init() {
        stack.push(0);
        visited[0] = true;
        System.out.print(0 + " ");
    }

    private void quest() {
        Integer peek = stack.peek();

        for (int i = grape[peek].length - 1; i >= 0; i--) {
            if (!visited[grape[peek][i]]) {
                visited[grape[peek][i]] = true;
                stack.push(grape[peek][i]);
                System.out.print(grape[peek][i] + " ");
                return;
            }
        }

        stack.pop();
    }
}
