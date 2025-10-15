package info.jab.cis194.homework1;

import java.util.List;
import java.util.Arrays;

public class Exercise4 {

    /**
     * Validate whether an Integer could be a valid credit card number.
     * Uses the Luhn algorithm:
     * 1. Convert to digits
     * 2. Double every other digit from the right
     * 3. Sum all digits
     * 4. Check if sum is divisible by 10
     * 
     * @param number the credit card number to validate
     * @return true if the number is valid, false otherwise
     */
    public boolean validate(long number) {
        if (number <= 0) {
            return false;
        }
        
        // Step 1: Convert to digits
        List<Integer> digits = toDigits(number);
        if (digits.isEmpty()) {
            return false;
        }
        
        // Step 2: Double every other digit from the right
        List<Integer> doubled = doubleEveryOther(digits);
        
        // Step 3: Sum all digits
        int sum = sumDigits(doubled);
        
        // Step 4: Check if sum is divisible by 10
        return sum % 10 == 0;
    }
    
    /**
     * Convert positive Integers to a list of digits.
     * For 0 or negative inputs, returns the empty list.
     * 
     * @param n the number to convert
     * @return list of digits from left to right
     */
    private List<Integer> toDigits(long n) {
        if (n <= 0) {
            return Arrays.asList();
        }
        
        java.util.List<Integer> digits = new java.util.ArrayList<>();
        while (n > 0) {
            digits.add((int) (n % 10));
            n /= 10;
        }
        
        java.util.Collections.reverse(digits);
        return digits;
    }
    
    /**
     * Double every other number beginning from the right.
     * That is, the second-to-last, fourth-to-last, etc. numbers are doubled.
     * 
     * @param digits the list of digits
     * @return list with every other digit doubled (from the right)
     */
    private List<Integer> doubleEveryOther(List<Integer> digits) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        
        for (int i = 0; i < digits.size(); i++) {
            int digit = digits.get(i);
            // Check if this position should be doubled (counting from the right)
            // If the position from the right is even (0-indexed), then double it
            int positionFromRight = digits.size() - 1 - i;
            if (positionFromRight % 2 == 1) { // second-to-last, fourth-to-last, etc.
                result.add(digit * 2);
            } else {
                result.add(digit);
            }
        }
        
        return result;
    }
    
    /**
     * Calculate the sum of all digits in the list.
     * For multi-digit numbers, each digit is summed individually.
     * 
     * @param numbers the list of numbers
     * @return sum of all digits
     */
    private int sumDigits(List<Integer> numbers) {
        int sum = 0;
        
        for (int number : numbers) {
            sum += sumDigitsOfNumber(number);
        }
        
        return sum;
    }
    
    /**
     * Helper method to sum the digits of a single number.
     * 
     * @param number the number to sum digits of
     * @return sum of digits
     */
    private int sumDigitsOfNumber(int number) {
        if (number == 0) {
            return 0;
        }
        
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        
        return sum;
    }
}