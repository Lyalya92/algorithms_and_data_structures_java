package lesson4;


public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> customLinkedList = new OneWayLinkedList<>();
        customLinkedList.addLast(1);
        customLinkedList.addLast(2);
        customLinkedList.addLast(3);
        customLinkedList.addLast(4);
        customLinkedList.addLast(5);

        System.out.println("One way linked list: ");
        for (Integer i: customLinkedList) {
            System.out.println(i);
        }

        LinkedList<Integer> customLinkedListTwoWay = new TwoWayLinkedList<>();
        customLinkedListTwoWay.addLast(11);
        customLinkedListTwoWay.addLast(12);
        customLinkedListTwoWay.addLast(13);
        customLinkedListTwoWay.addLast(14);

        System.out.println("Two way linked list: ");
        for (Integer i: customLinkedListTwoWay) {
            System.out.println(i);
        }

    }
}
