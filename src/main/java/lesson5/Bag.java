package lesson5;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private int capacity;
    List<Thing> filledBag = null;
    private int bestPrice;
    private int weightOfBag;

    public Bag(int capacity) {
        this.capacity = capacity;
        this.bestPrice = 0;
        this.weightOfBag = 0;
    }

    private int calculateWeight(List<Thing> things) {
        int sumWeight = 0;
        for (Thing th: things) {
            sumWeight += th.getWeight();
        }
        return sumWeight;
    }

    private int calculatePrice(List<Thing> things) {
        int sumPrice = 0;
        for (Thing th: things) {
            sumPrice += th.getPrice();
        }
        return sumPrice;
    }

    private void checkSetOfThings(List<Thing> things) {
        if (filledBag == null) {
            if (calculateWeight(things) <= this.capacity) {
                this.filledBag = things;
                this.bestPrice = calculatePrice(things);
            }
        } else {
            if (calculateWeight(things) <=capacity && calculatePrice(things) > bestPrice) {
                filledBag = things;
                this.bestPrice = calculatePrice(things);
                this.weightOfBag = calculateWeight(things);
            }
        }
    }

    public void getBestSetOfThings(List<Thing> things) {
        findMaxPriceSet(things);
        System.out.println();
    }
    private void findMaxPriceSet(List<Thing> things) {
        if (things.size() > 0) {
            checkSetOfThings(things);
            for (int i = 0; i < things.size(); i++) {
                List <Thing> newList = new ArrayList<>(things);
                newList.remove(i);
                findMaxPriceSet(newList);
            }
        }
    }


    public void showBag(){
        if (filledBag == null) {
            System.out.println("Bag is empty!");
            return;
        }
        for (Thing thing: filledBag) {
            System.out.println("weight: " + thing.getWeight() + " price: " + thing.getPrice());
        }
    }


    public int getCapacity(){
        return this.capacity;
    }

    public int getBestPrice() {
        return this.bestPrice;
    }

    public int getWeightOfBag() {
        return this.weightOfBag;
    }

    @Override
    public String toString() {
        String str = "";
        if (filledBag == null) {
            str = "Bag is empty!";
            return str;
        }
        for (Thing thing: filledBag) {
            str = str + "weight: " + thing.getWeight() + " price: " + thing.getPrice() +"\n";
        }
        return str;
    }
}
