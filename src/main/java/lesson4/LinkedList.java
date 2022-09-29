package lesson4;

public interface LinkedList<T> extends Iterable<T>{
    void addFirst(T element);
    void addLast (T element);
    void add(T element, int index);

    T get(int index);
    T getFirst();
    T getLast();

    void delete (int index);
    void deleteFirst();
    void deleteLast();


}
