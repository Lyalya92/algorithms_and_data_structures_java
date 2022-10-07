package lesson7;

import java.util.function.Consumer;

public interface Graph {

    boolean addVertex(String label);

    boolean addEdge(String from, String to, int weight);

    boolean addTwoSidedEdge(String from, String to, int weight);

    void dfs(String start, Consumer<String> visitor);

    void bfs(String start, Consumer<String> visitor);

//    int getMinRoute(String from, String to);

}
