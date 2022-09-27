package lesson4;

import java.util.Iterator;

public class OneWayLinkedList<T> implements LinkedList<T> {

    protected class Node<T> {
        protected T value;
        protected Node<T> next;


        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value) {
            this.value = value;
        }

    }

    protected Node<T> head;

    public OneWayLinkedList(){

    }

    @Override
    public void addFirst(T element) {
        if (head == null) {
            head = new Node<>(element);
            return;
        }
          head = new Node<>(element, head);
    }


    @Override
    public void addLast(T element) {
        if (head == null) {
            head = new Node<>(element);
            return;
        }
        Node<T> lastNode = getLastNode();
        lastNode.next = new Node(element);

    }

    protected Node<T> getLastNode() {
        return head != null ? getNode(getLastNodeIndex()) :null;
    }

    protected int getLastNodeIndex() {
        int counter = 0;
        if (head == null) {
            throw  new IllegalArgumentException("List is empty");
        }
        Node <T> last = head;
        while (last.next != null){
            last = last.next;
            counter++;
        }
        return counter;
    }

    @Override
    public T getFirst() {
        return head != null ? head.value : null;
    }

    @Override
    public T getLast() {
        Node <T> lastNode = getLastNode();
        return lastNode != null ? lastNode.value : null;
    }

    protected Node<T> getNode(int index) {
        if (head == null) {
            throw new IllegalArgumentException("Index " + index + " out of bounds");
        }
        int counter = 0;
        Node<T> currentNode = head;
        while (counter != index && currentNode.next != null) {
            currentNode = currentNode.next;
            counter++;
        }
        if (counter != index) {
            throw new IllegalArgumentException("Index " + index + " out of bounds");
        }

        return currentNode;
    }


    @Override
    public void add(T element, int index) {
        if (index == 0) {
            addFirst(element);
        }

       Node<T> node = getNode(index - 1);
       Node<T> newNextNode = node.next;
       node.next = new Node<>(element, newNextNode);
    }


    @Override
    public T get(int index) {
      Node <T> node = getNode(index);
      return node != null ? node.value : null;
    }


    @Override
    public void delete(int index) {
        if (index == 0) {
            if (head == null) {
                throw  new IllegalArgumentException("Index " + index + " out of bounds");
            }
            head = head.next;
            return;
        }

        Node<T> node = getNode(index - 1);
        Node<T> nodeForRemove = node.next;
        if (nodeForRemove == null) {
            throw  new IllegalArgumentException("Index " + index + " out of bounds");

        }
        Node<T> newNextNode = nodeForRemove.next;
        node.next = newNextNode;

    }

    @Override
    public void deleteFirst() {
        if (head == null) {
            throw  new IllegalArgumentException("List is empty");
        }
        head = head.next;
    }

    @Override
    public void deleteLast() {
        if (head == null) {
            throw  new IllegalArgumentException("List is empty");
        }
        int index = getLastNodeIndex();
        delete(index);
    }


    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

     private class MyIterator<T> implements Iterator {
        private Node<T> pointer = (Node<T>) head;

        @Override
        public boolean hasNext() {
            if (pointer != null) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            T ret = pointer.value;
            pointer = pointer.next;
            return ret;
        }
    }

    @Override
    public String toString() {
    StringBuilder out = new StringBuilder();
    Node<T> iterator = head;
    while (iterator != null) {
        out.append(iterator.value).append(" ");
        iterator = iterator.next;

    }

    return "[ " + out + "]";
    }
}
