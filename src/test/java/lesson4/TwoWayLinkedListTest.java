package lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TwoWayLinkedListTest {

    private TwoWayLinkedList<Integer> createLinkedList() {
        return new TwoWayLinkedList<>();
    }

    @Test
    void testEmptyList() {
        Assertions.assertEquals("[ ]", createLinkedList().toString());
    }

    @Test
    void testAddLast() {
        LinkedList<Integer> list = createLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        Assertions.assertEquals("[ 1 2 3 4 ]", list.toString());
    }

    @Test
    void testAddFirst() {
        LinkedList<Integer> list = createLinkedList();
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        Assertions.assertEquals("[ 1 2 3 4 ]", list.toString());
    }

    @Test
    void testAddByIndex() {
        LinkedList<Integer> list = createLinkedList();
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.add(10,1));
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.add(8, 1);
        Assertions.assertEquals("[ 1 8 2 3 4 ]", list.toString());
        list.add(10, 2);
        Assertions.assertEquals("[ 1 8 10 2 3 4 ]", list.toString());
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.add(10,15));
    }

    @Test
    void testGetFirst() {
        LinkedList<Integer> list = createLinkedList();
        Assertions.assertNull(list.getFirst());
        list.addFirst(4);
        Assertions.assertEquals(4, list.getFirst());
        list.addFirst(3);
        list.addFirst(2);
        Assertions.assertEquals(2, list.getFirst());
        list.addFirst(1);
        Assertions.assertEquals(1, list.getFirst());
    }

    @Test
    void testGetLast() {
        LinkedList<Integer> list = createLinkedList();
        Assertions.assertNull(list.getLast());
        list.addLast(1);
        list.addLast(2);
        Assertions.assertEquals(2, list.getLast());
        list.addLast(3);
        list.addLast(4);
        Assertions.assertEquals(4, list.getLast());
    }

    @Test
    void testGetByIndex() {
        LinkedList<Integer> list = createLinkedList();
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.get(0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.get(5));

        list.addFirst(3);
        Assertions.assertEquals(3, list.get(0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.get(1));

        list.addFirst(2);
        list.addFirst(1);
        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(2, list.get(1));
        Assertions.assertEquals(3, list.get(2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.get(3));
    }

    @Test
    void testDeleteFirst() {
        LinkedList<Integer> list = createLinkedList();
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.deleteFirst());
        list.addLast(1);
        list.addLast(2);
        list.deleteFirst();
        Assertions.assertEquals("[ 2 ]", list.toString());
    }

    @Test
    void testDeleteLast() {
        LinkedList<Integer> list = createLinkedList();
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.deleteLast());
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.deleteLast();
        Assertions.assertEquals("[ 1 2 3 ]", list.toString());
        list.deleteLast();
        list.deleteLast();
        Assertions.assertEquals("[ 1 ]", list.toString());
    }

    @Test
    void testDeleteByIndex() {
        LinkedList<Integer> list = createLinkedList();
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.delete(0));
        list.addLast(1);
        list.addLast(2);
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.delete(2));
        list.delete(1);
        Assertions.assertEquals("[ 1 ]", list.toString());
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.delete(1));
    }
}