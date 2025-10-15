package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Exercise1 {

    /**
     * Convert positive Integer to a list of digits.
     * For 0 or negative inputs, returns empty list.
     */
    public static List<Integer> toDigits(Integer n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(n % 10);
            n = n / 10;
        }
        Collections.reverse(digits);
        return digits;
    }

    /**
     * Convert positive Integer to a list of digits in reverse order.
     * For 0 or negative inputs, returns empty list.
     */
    public static List<Integer> toDigitsRev(Integer n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(n % 10);
            n = n / 10;
        }
        return digits;
    }
}