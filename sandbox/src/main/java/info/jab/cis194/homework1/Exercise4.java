package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise4 {

    private final Exercise1 exercise1 = new Exercise1();
    private final Exercise2 exercise2 = new Exercise2();
    private final Exercise3 exercise3 = new Exercise3();

    /**
     * Validate whether a Long could be a valid credit card number using the Luhn algorithm.
     * 
     * @param number the credit card number to validate
     * @return true if the number is valid, false otherwise
     */
    public Boolean validate(Long number) {
        if (number <= 0) {
            return false;
        }
        
        // Convert to digits - handle Long properly
        List<Integer> digits = toDigitsLong(number);
        
        // Double every other digit from the right
        List<Integer> doubledDigits = exercise2.doubleEveryOther(digits);
        
        // Sum all digits
        Integer sum = exercise3.sumDigits(doubledDigits);
        
        // Check if sum is divisible by 10
        return sum % 10 == 0;
    }
    
    /**
     * Convert a Long to a list of digits.
     * 
     * @param n the long to convert
     * @return list of digits from left to right
     */
    private List<Integer> toDigitsLong(Long n) {
        List<Integer> digits = new ArrayList<>();
        if (n <= 0) {
            return digits;
        }
        
        while (n > 0) {
            digits.add((int)(n % 10));
            n = n / 10;
        }
        Collections.reverse(digits);
        return digits;
    }
}