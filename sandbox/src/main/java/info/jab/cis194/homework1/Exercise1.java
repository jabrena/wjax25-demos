package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise1 {

    /**
     * Converts a positive Integer to a list of digits.
     * For 0 or negative inputs, returns an empty list.
     * 
     * @param n the integer to convert
     * @return list of digits in order
     */
    public static List<Integer> toDigits(Integer n) {
        if (n <= 0) {
            return Collections.emptyList();
        }
        
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(0, n % 10); // Insert at beginning to maintain order
            n /= 10;
        }
        return digits;
    }

    /**
     * Converts a positive Integer to a list of digits in reverse order.
     * For 0 or negative inputs, returns an empty list.
     * 
     * @param n the integer to convert
     * @return list of digits in reverse order
     */
    public static List<Integer> toDigitsRev(Integer n) {
        if (n <= 0) {
            return Collections.emptyList();
        }
        
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(n % 10); // Add to end to get reverse order
            n /= 10;
        }
        return digits;
    }
}