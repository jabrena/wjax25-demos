package info.jab.cis194.homework1;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Exercise4 {

    private final Exercise1 exercise1 = new Exercise1();
    private final Exercise2 exercise2 = new Exercise2();
    private final Exercise3 exercise3 = new Exercise3();

    /**
     * Validates a credit card number using the Luhn algorithm.
     * 
     * @param cardNumber the credit card number to validate
     * @return true if the card number is valid, false otherwise
     */
    public Boolean validate(Long cardNumber) {
        if (cardNumber <= 0) {
            return false;
        }
        
        // Step 1: Convert to digits (handle Long properly)
        List<Integer> digits = toDigitsLong(cardNumber);
        if (digits.isEmpty()) {
            return false;
        }
        
        // Step 2: Double every other digit from the right
        List<Integer> doubledDigits = exercise2.doubleEveryOther(digits);
        
        // Step 3: Sum all digits
        Integer sum = exercise3.sumDigits(doubledDigits);
        
        // Step 4: Check if sum is divisible by 10
        return sum % 10 == 0;
    }
    
    /**
     * Convert a Long to a list of digits.
     * 
     * @param n the Long to convert
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