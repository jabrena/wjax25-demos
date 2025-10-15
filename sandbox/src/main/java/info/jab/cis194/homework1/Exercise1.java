package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise1 {

    /**
     * Convert positive Integers to a list of digits.
     * For 0 or negative inputs, returns the empty list.
     * 
     * @param n the integer to convert
     * @return list of digits from left to right
     */
    public List<Integer> toDigits(Integer n) {
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
     * Convert positive Integers to a list of digits in reverse order.
     * For 0 or negative inputs, returns the empty list.
     * 
     * @param n the integer to convert
     * @return list of digits from right to left
     */
    public List<Integer> toDigitsRev(Integer n) {
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