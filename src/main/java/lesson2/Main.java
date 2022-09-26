package lesson2;

import java.util.Arrays;


public class Main {
//    final static int ARRAY_SIZE = 1000;
    final static int ARRAY_SIZE = 30;

    public static void main(String[] args) {

        Notebook [] notebooks = new Notebook[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            notebooks[i] = Notebook.generateNotebook();
        }

        System.out.println("Generated array: ");
        printArray(notebooks);
        System.out.println();

        System.out.println("Sorted array: ");
        Arrays.sort(notebooks, new NoteBookComparator().reversed());
        printArray(notebooks);
    }

    public static void printArray (Notebook [] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i].print();
        }
        Notebook.counter = 0;
    }
}
