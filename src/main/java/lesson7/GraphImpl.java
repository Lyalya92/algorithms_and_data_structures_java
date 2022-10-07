package lesson7;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;


public class GraphImpl implements Graph {

    private final List<String> vertexes = new ArrayList<>();
    private final List<List<Integer>> adjMatrix = new ArrayList<>();

    @Override
    public boolean addVertex(String label) {
        Objects.requireNonNull(label);

        if (indexOf(label) >=0) return false;

        for (String vertex: vertexes) {
            if (label.equals(vertex)) {
                return false;
            }
        }
        vertexes.add(label);

        for (List<Integer> row : adjMatrix) {
            row.add(0);
        }

        int size = vertexes.size();
        List<Integer> newRow = new ArrayList<>();
        for(int i = 0; i< size; i++) {
            newRow.add(0);
        }
        adjMatrix.add(newRow);


        return true;
    }

    private int indexOf (String label) {
        for(int i = 0; i < vertexes.size(); i++) {
            if (label.equals(vertexes.get(i))) return i;
        }
       return -1;
    }

    @Override
    public boolean addEdge(String from, String to, int weight) {
        if(from == null || to == null || from.equals(to)) return false;

        int indexOfFrom = indexOf(from);
        int indexOfTo = indexOf(to);

        if (indexOfFrom == -1 || indexOfTo == -1) return false;

        List<Integer> fromEdges = adjMatrix.get(indexOfFrom);
        fromEdges.set(indexOfTo, weight);

        return true;
    }

    @Override
    public boolean addTwoSidedEdge(String from, String to, int weight) {
        return addEdge(from, to, weight) && addEdge(to,from, weight);
    }

    @Override
    public void dfs(String start, Consumer<String> visitor) {
        Objects.requireNonNull(start);
        dfs(start, new HashSet<>(), visitor);
    }

    private void dfs(String current, Set<String> visited, Consumer<String> visitor) {
        if (visited.contains(current)) {
            return;
        }
        visitor.accept(current);
        visited.add(current);

        List<String> neighbors = getNeighbors(current);
        for (String neighbor : neighbors) {
            dfs(neighbor, visited, visitor);
        }

    }

    @Override
    public void bfs(String start, Consumer<String> visitor) {
        Objects.requireNonNull(start);

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String next = queue.poll();
            visitor.accept(next);
            List<String> neighbors = getNeighbors(next);
            for (String neighbor : neighbors) {
                if (visited.add(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }
    }

    private List<String> getNeighbors(String vertex) {
        List<Integer> vertexRow = adjMatrix.get(indexOf(vertex));
        List<String> neighbors = new ArrayList<>();
        for (int i = 0; i < vertexRow.size(); i++) {
            if (vertexRow.get(i) > 0) {
                String neighbor = vertexes.get(i);
                neighbors.add(neighbor);
            }
        }
        return neighbors;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (List<Integer> row : adjMatrix) {
            String routes = row.stream().map(String::valueOf).collect(Collectors.joining(" "));
            stringBuilder.append(routes).append("\n");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        return stringBuilder.toString();
    }
}
