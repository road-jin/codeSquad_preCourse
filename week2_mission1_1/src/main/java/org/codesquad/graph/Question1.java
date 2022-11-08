package org.codesquad.graph;

public class Question1 {

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.add(0, 1,2);
        graph.add(1, 0,3,4);
        graph.add(2, 0,5,6);
        graph.add(3, 1,7);
        graph.add(4, 1,5);
        graph.add(5, 2,4);
        graph.add(6, 2);
        graph.add(7, 3);
        graph.show();

        Bfs bfs = new Bfs(graph.get());
        bfs.run();

        Dfs dfs = new Dfs(graph.get());
        dfs.run();
    }
}
