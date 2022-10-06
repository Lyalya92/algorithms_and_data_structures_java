package lesson6;

import java.util.function.Consumer;

public interface Tree <T extends Comparable<T>> {

    void add (T item);

    boolean contains(T item);

    void remove(T item);

    // dept-first search  -- поиск в глубину
    void dfs(Consumer<T> visitor);

    // breadth-first search -- поиск в ширину
    void bfs(Consumer<T> visitor);

    boolean isBalanced();
}
