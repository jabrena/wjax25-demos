package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Exercise1 {

    /**
     * Convert positive Integers to a list of digits.
     * For 0 or negative inputs, returns the empty list.
     * 
     * @param n the number to convert
     * @return list of digits from left to right
     */
    public List<Integer> toDigits(long n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add((int) (n % 10));
            n /= 10;
        }
        
        Collections.reverse(digits);
        return digits;
    }

    /**
     * Convert positive Integers to a list of digits in reverse order.
     * For 0 or negative inputs, returns the empty list.
     * 
     * @param n the number to convert
     * @return list of digits from right to left
     */
    public List<Integer> toDigitsRev(long n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add((int) (n % 10));
            n /= 10;
        }
        
        return digits;
    }
}