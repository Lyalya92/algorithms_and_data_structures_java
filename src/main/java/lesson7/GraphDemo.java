package lesson7;

public class GraphDemo {
    public static void main(String[] args) {
        Graph graph = new GraphImpl();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addTwoSidedEdge("A","B", 5);
        graph.addTwoSidedEdge("B","E", 7);
        graph.addTwoSidedEdge("E","C", 1);
        graph.addTwoSidedEdge("C","A", 2);
        graph.addTwoSidedEdge("D","A", 3);
        graph.addTwoSidedEdge("D","E", 8);


        System.out.println(graph);
        System.out.println();
        graph.dfs("A", System.out::print);
        System.out.println();
        graph.bfs("A", System.out::print);
    }


}
