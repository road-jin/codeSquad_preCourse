package org.codesquad.graph;

import java.util.Arrays;

public class Graph {

    private final int vertex;
    private final int[][] edge;

    public Graph(int vertex) {
        this.vertex = vertex;
        this.edge = new int[vertex][vertex];
    }

    public void add(int vertex, int... adjacencyVertex) {
        edge[vertex] = adjacencyVertex;
    }

    public void show() {
        Arrays.stream(edge)
                .forEach(ints -> {
                    Arrays.stream(ints)
                            .forEach(System.out::print);
                    System.out.println();
                });
    }

    public int[][] get() {
        return edge;
    }
}
