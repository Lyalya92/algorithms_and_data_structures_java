package lesson5;

public class ExponentiationRecursive {

    public static long exponentiation(long base, long exponent) {
        if (exponent < 0)  {
            throw new IllegalArgumentException("Exponent can't be negative!");
        }
        if (exponent == 0) return 1;
        if (base == 0) return 0;
        return base * exponentiation(base, exponent - 1);
    }
}
