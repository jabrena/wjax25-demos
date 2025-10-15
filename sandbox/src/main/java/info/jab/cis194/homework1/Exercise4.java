package info.jab.cis194.homework1;

import java.util.List;

public class Exercise4 {
    
    private final Exercise1 exercise1 = new Exercise1();
    private final Exercise2 exercise2 = new Exercise2();
    private final Exercise3 exercise3 = new Exercise3();
    
    /**
     * Validate whether a credit card number is valid using the Luhn algorithm.
     * 
     * Steps:
     * 1. Convert number to digits
     * 2. Double every other digit from the right
     * 3. Sum all digits
     * 4. Check if sum is divisible by 10
     */
    public Boolean validate(Long creditCardNumber) {
        if (creditCardNumber <= 0) {
            return false;
        }
        
        // Step 1: Convert to digits
        List<Integer> digits = toDigits(creditCardNumber);
        
        // Step 2: Double every other digit from the right
        List<Integer> doubledDigits = exercise2.doubleEveryOther(digits);
        
        // Step 3: Sum all digits
        Integer sum = exercise3.sumDigits(doubledDigits);
        
        // Step 4: Check if sum is divisible by 10
        return sum % 10 == 0;
    }
    
    /**
     * Convert Long to list of digits.
     */
    private List<Integer> toDigits(Long number) {
        if (number <= 0) {
            return new java.util.ArrayList<>();
        }
        
        List<Integer> digits = new java.util.ArrayList<>();
        while (number > 0) {
            digits.add((int)(number % 10));
            number /= 10;
        }
        java.util.Collections.reverse(digits);
        return digits;
    }
}