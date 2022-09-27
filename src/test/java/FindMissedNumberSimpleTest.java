import lesson3.FindMissedNumberSimple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindMissedNumberSimpleTest {
    FindMissedNumberSimple findMissedNumber = new FindMissedNumberSimple();

    @Test
    void testSearch() {
        int [] arr1 = {1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16};
        int [] arr2 = {1, 2, 4, 5, 6};
        int [] arr3 = {2, 3, 4, 5, 6, 7, 8};
        int [] arr4 = {1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14};
        int [] arr5 = {};
        Assertions.assertEquals(11, findMissedNumber.search(arr1));
        Assertions.assertEquals(3, findMissedNumber.search(arr2));
        Assertions.assertEquals(1, findMissedNumber.search(arr3));
        Assertions.assertEquals(7, findMissedNumber.search(arr4));
        Assertions.assertEquals(1, findMissedNumber.search(arr5));

    }



}
