package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise1 {

    /**
     * Convert positive Integer to a list of digits.
     * For 0 or negative inputs, returns empty list.
     * 
     * @param n the integer to convert
     * @return list of digits from left to right
     */
    public List<Integer> toDigits(Integer n) {
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
     * Convert positive Integer to a list of digits in reverse order.
     * For 0 or negative inputs, returns empty list.
     * 
     * @param n the integer to convert
     * @return list of digits from right to left
     */
    public List<Integer> toDigitsRev(Integer n) {
        if (n <= 0) {
            return Collections.emptyList();
        }
        
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(n % 10); // Add to end to maintain reverse order
            n /= 10;
        }
        return digits;
    }
}