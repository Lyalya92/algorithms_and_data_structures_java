package lesson6;

import java.util.*;
import java.util.function.Consumer;

public class BinaryTree<T extends Comparable<T>> implements Tree<T> {

    private class Node{
        private T value;
        private Node left;
        private Node right;

        public Node (T value) {
            this.value = value;
        }
    }

    private Node root;

    @Override
    public void add(T item) {
        Objects.requireNonNull(item);
        root = appendNode(root, item);
    }

    private Node appendNode(Node current, T value) {
        if (current == null) {
            return new Node(value);
        }
        int compare = value.compareTo(current.value);
        switch (compare) {
            case -1: current.left = appendNode(current.left, value); break;
            case  1: current.right = appendNode(current.right, value); break;
            default: break;
        }
        return current;
    }

    @Override
    public boolean contains(T item) {
        Node node = findNode(root, item);
        return node != null;
    }

    private Node findNode (Node current, T value) {
        if (current == null) return null;
        int compare = value.compareTo(current.value);
        switch (compare) {
            case -1: return findNode(current.left, value);
            case  1: return findNode(current.right, value);
            default: break;
        }
        return current;
    }

    @Override
    public void remove(T item) {
        root = removeNode(root, item);
    }

    private Node removeNode(Node current, T value) {
        if (current == null) return null;
        int compare = value.compareTo(current.value);
        switch (compare) {
            case -1: current.left = removeNode(current.left, value); return current;
            case  1: current.right = removeNode(current.right, value); return current;
            default: break;
        }

        // у текущего узла нет дочерних узлов
        if (current.left == null && current.right == null) {
            return null;
        }

        // есть только правый ненулевой узел
        if (current.left == null) {
            return current.right;
        }

        // есть только левый ненулевой узел
        if (current.right == null) {
            return current.left;
        }

        // оба узла ненулевые -> ищем минимальный узел справа
        Node minOnTheRight = findMin(current.right);
        current.value = minOnTheRight.value;
        current.right = removeNode(current.right, minOnTheRight.value);
        return current;
    }

    private Node findMin(Node current) {
        Node left = current.left;
        return left == null ? current : findMin(left);
    }


    @Override
    public void dfs(Consumer<T> visitor) {
        dfs(root,visitor);
    }

    private void dfs(Node current, Consumer<T> visitor) {
        if (current != null) {
            dfs(current.left, visitor);
            visitor.accept(current.value);
            dfs(current.right, visitor);
        }
    }

    public List<T> collectDfs() {
        List<T> items = new ArrayList<>();
        dfs(items::add);
        return items;
    }

    public void printDfs() {
        dfs(System.out::println);
    }

    @Override
    public void bfs(Consumer<T> visitor) {
        if (root == null) {
            return;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
            Node node = nodes.poll();
            visitor.accept(node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }

    @Override
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node current) {
        Node leftChild = current.left;
        Node rightChild = current.right;
        if (leftChild == null && rightChild == null) return true;
            if (leftChild == null) {
                if (rightChild.left !=null || rightChild.right !=null) return false;
                }
            if (rightChild == null) {
                if (leftChild.left !=null || leftChild.right !=null) {return false;}
                else return true;
            }
        return  isBalanced(leftChild) && isBalanced(rightChild);
    }

}
