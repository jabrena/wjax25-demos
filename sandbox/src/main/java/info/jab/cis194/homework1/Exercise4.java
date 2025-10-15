package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.List;

public class Exercise4 {

    /**
     * Validate a credit card number using the Luhn algorithm.
     * Returns true if the number could be a valid credit card number.
     */
    public static boolean validate(long creditCardNumber) {
        if (creditCardNumber <= 0) {
            return false;
        }
        
        // Convert to digits (handle long numbers properly)
        List<Integer> digits = toDigitsRev(creditCardNumber);
        
        // Double every other digit from the right
        List<Integer> doubledDigits = Exercise2.doubleEveryOther(digits);
        
        // Sum all digits
        int sum = Exercise3.sumDigits(doubledDigits);
        
        // Check if the remainder when divided by 10 equals 0
        return sum % 10 == 0;
    }
    
    /**
     * Convert a long to a list of digits in reverse order.
     */
    private static List<Integer> toDigitsRev(long n) {
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add((int) (n % 10));
            n = n / 10;
        }
        return digits;
    }
}