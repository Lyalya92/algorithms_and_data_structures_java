package lesson3;

public class FindMissedNumberSimple {

    public int search(int [] arr) {
        if (arr == null || arr.length == 0) return 1;
        int i;
        for(i = 0; i < arr.length; i++) {
            if (arr[i] != i+1) {
                return i+1;
            }
        }
        return i+1;
    }
}
