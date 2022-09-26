package lesson3;

public class FindMissedNumber {

    public int search(int [] arr) {
        if (arr.length == 0 || arr == null) return 1;
        int range1 = 0;
        int range2 = arr.length - 1;
        int middlePoint = (range2 - range1)/2;

        do {
            if (arr[middlePoint] == middlePoint + 1) {
                range1 = middlePoint;
            } else {
                range2 = middlePoint;
            }
            middlePoint = range1 + (range2 - range1)/2;
        } while (middlePoint != range1 );

        if (arr[middlePoint] != middlePoint + 1)  return middlePoint +1;
        return middlePoint + 2;
    }
}
