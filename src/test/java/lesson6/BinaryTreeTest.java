package lesson6;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private BinaryTree<Integer> createTree() {
        return new BinaryTree<>();
    }

    @Test
    void testAddAndContains() {
        BinaryTree<Integer> tree = createTree();
        assertFalse(tree.contains(5));
        tree.add(5);
        assertTrue(tree.contains(5));
        tree.add(8);
        tree.add(13);
        tree.add(7);

        assertTrue(tree.contains(8));
        assertTrue(tree.contains(13));
        assertTrue(tree.contains(7));
    }

    @Test
    void testRemove() {
        BinaryTree<Integer> tree = createTree();
        tree.add(5);
        assertTrue(tree.contains(5));
        tree.remove(5);
        assertFalse(tree.contains(5));

        tree = createTree();
        tree.add(8);
        tree.add(4);
        tree.add(6);
        tree.add(3);
        tree.add(1);
        tree.add(2);
        tree.remove(8);
        assertFalse(tree.contains(8));
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(6));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));
    }

    @Test
    void testDfs() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(8);
        tree.add(3);
        tree.add(10);
        tree.add(1);
        tree.add(6);
        tree.add(4);
        tree.add(7);
        tree.add(14);
        tree.add(13);

        Queue<Integer> integers = new ArrayDeque<>();
        tree.dfs(integers::add);
        assertEquals(9, integers.size());
        assertEquals(1, integers.poll());
        assertEquals(3, integers.poll());
        assertEquals(4, integers.poll());
        assertEquals(6, integers.poll());
        assertEquals(7, integers.poll());
        assertEquals(8, integers.poll());
        assertEquals(10, integers.poll());
        assertEquals(13, integers.poll());
        assertEquals(14, integers.poll());
        assertNull(integers.poll());
    }

    @Test
    void testBfs() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(8);
        tree.add(3);
        tree.add(10);
        tree.add(1);
        tree.add(6);
        tree.add(4);
        tree.add(7);
        tree.add(14);
        tree.add(13);

        Queue<Integer> integers = new ArrayDeque<>();
        tree.bfs(integers::add);
        assertEquals(9, integers.size());

        assertEquals(8, integers.poll());
        assertEquals(3, integers.poll());
        assertEquals(10, integers.poll());
        assertEquals(1, integers.poll());
        assertEquals(6, integers.poll());
        assertEquals(14, integers.poll());
        assertEquals(4, integers.poll());
        assertEquals(7, integers.poll());
        assertEquals(13, integers.poll());
        assertNull(integers.poll());
    }

    @Test
    void testIsBalanced() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(8);
        assertTrue(tree.isBalanced());
        tree.add(5);
        assertTrue(tree.isBalanced());
        tree.add(10);
        tree.add(2);
        assertTrue(tree.isBalanced());
        tree.add(1);
        assertFalse(tree.isBalanced());

        tree = new BinaryTree<>();
        tree.add(8);
        tree.add(3);
        tree.add(10);
        tree.add(1);
        tree.add(6);
        tree.add(4);
        tree.add(7);
        tree.add(14);
        tree.add(13);
        assertFalse(tree.isBalanced());

    }
}