package lesson5;

import java.util.ArrayList;
import java.util.List;

public class BagSolution {
    private static List<Thing> allThings;

    public static void main(String[] args) {

        allThings = new ArrayList<>();
        allThings.add(new Thing(10, 1));
        allThings.add(new Thing(15, 3));
        allThings.add(new Thing(5, 2));
        allThings.add(new Thing(20, 4));
        allThings.add(new Thing(8, 5));
        allThings.add(new Thing(30, 8));
        allThings.add(new Thing(15, 2));
        allThings.add(new Thing(20, 7));
        allThings.add(new Thing(6, 1));

        Bag bag1 = new Bag(5);
        System.out.println(bag1);
        System.out.println("Best set of things by capacity = " + bag1.getCapacity() + ":");
        bag1.getBestSetOfThings(allThings);
        System.out.println(bag1);
        System.out.println("Weight of bag = " + bag1.getWeightOfBag());
        System.out.println("Best price of bag = " + bag1.getBestPrice());


        System.out.println();
        Bag bag2 = new Bag(10);
        System.out.println("Best set of things by capacity = " + bag2.getCapacity() + ":");
        bag2.getBestSetOfThings(allThings);
        System.out.println(bag2);
        System.out.println("Weight of bag = " + bag2.getWeightOfBag());
        System.out.println("Price of bag = " + bag2.getBestPrice());

    }

        private static void printListOfAllThings() {
        for (Thing thing: allThings) {
            System.out.println("weight: " + thing.getWeight() + " price: " + thing.getPrice());
        }
    }
}
