package info.jab.cis194.homework1;

import java.util.List;

public class Exercise4 {

    /**
     * Validate a credit card number using the Luhn algorithm.
     * 
     * @param cardNumber the credit card number to validate
     * @return true if the card number is valid, false otherwise
     */
    public static boolean validate(long cardNumber) {
        if (cardNumber <= 0) {
            return false;
        }
        
        // Step 1: Convert to digits
        List<Integer> digits = Exercise1.toDigits(cardNumber);
        
        // Step 2: Double every other digit from the right
        List<Integer> doubled = Exercise2.doubleEveryOther(digits);
        
        // Step 3: Sum all digits
        int sum = Exercise3.sumDigits(doubled);
        
        // Step 4: Check if sum is divisible by 10
        return sum % 10 == 0;
    }
}