package lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExponentiationRecursiveTest {

    @Test
    void testExponentiation(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->ExponentiationRecursive.exponentiation(2,-3));
        Assertions.assertEquals(8,ExponentiationRecursive.exponentiation (2L, 3L));
        Assertions.assertEquals(1,ExponentiationRecursive.exponentiation (12L, 0));
        Assertions.assertEquals(0,ExponentiationRecursive.exponentiation (0, 5L));
        Assertions.assertEquals(1,ExponentiationRecursive.exponentiation (0, 0));
    }
}