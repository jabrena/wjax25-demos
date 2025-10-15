package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise1 {
    
    /**
     * Convert positive Integer to a list of digits.
     * For 0 or negative inputs, returns empty list.
     */
    public List<Integer> toDigits(Integer number) {
        if (number <= 0) {
            return new ArrayList<>();
        }
        
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
        Collections.reverse(digits);
        return digits;
    }
    
    /**
     * Convert positive Integer to a list of digits in reverse order.
     * For 0 or negative inputs, returns empty list.
     */
    public List<Integer> toDigitsRev(Integer number) {
        if (number <= 0) {
            return new ArrayList<>();
        }
        
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
        return digits;
    }
}