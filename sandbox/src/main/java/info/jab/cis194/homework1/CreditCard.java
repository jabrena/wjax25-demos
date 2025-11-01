package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Credit Card Validation implementation for CIS-194 Homework 1.
 * Implements the Luhn algorithm for validating credit card numbers.
 */
public class CreditCard {

    /**
     * Exercise 1: Convert a positive Integer to a list of digits.
     * Returns empty list for 0 or negative inputs.
     * 
     * @param n the number to convert
     * @return list of digits from left to right
     */
    public static List<Integer> toDigits(long n) {
        if (n <= 0) {
            return Collections.emptyList();
        }
        
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add((int)(n % 10));
            n = n / 10;
        }
        Collections.reverse(digits);
        return digits;
    }

    /**
     * Exercise 1: Convert a positive Integer to a list of digits (reversed).
     * Returns empty list for 0 or negative inputs.
     * 
     * @param n the number to convert
     * @return list of digits from right to left
     */
    public static List<Integer> toDigitsRev(long n) {
        if (n <= 0) {
            return Collections.emptyList();
        }
        
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add((int)(n % 10));
            n = n / 10;
        }
        return digits;
    }

    /**
     * Exercise 2: Double every other number beginning from the right.
     * The last digit is unchanged; the second-to-last digit is doubled; etc.
     * 
     * @param digits the list of digits to process
     * @return list with every other digit doubled from the right
     */
    public static List<Integer> doubleEveryOther(List<Integer> digits) {
        List<Integer> result = new ArrayList<>(digits);
        
        // Start from the right (second-to-last index)
        for (int i = result.size() - 2; i >= 0; i -= 2) {
            result.set(i, result.get(i) * 2);
        }
        
        return result;
    }

    /**
     * Exercise 3: Calculate the sum of all digits.
     * For two-digit numbers, both digits are summed separately.
     * 
     * @param digits the list of digits (may contain two-digit numbers)
     * @return the sum of all digits
     */
    public static long sumDigits(List<Integer> digits) {
        long sum = 0;
        for (int num : digits) {
            // Convert to string to handle two-digit numbers
            String numStr = String.valueOf(num);
            for (char c : numStr.toCharArray()) {
                sum += Character.getNumericValue(c);
            }
        }
        return sum;
    }

    /**
     * Exercise 4: Validate a credit card number using the Luhn algorithm.
     * 
     * Steps:
     * 1. Convert to digits
     * 2. Double every other digit from the right
     * 3. Sum all digits
     * 4. Check if remainder when divided by 10 is 0
     * 
     * @param cardNumber the credit card number to validate
     * @return true if valid, false otherwise
     */
    public static boolean validate(long cardNumber) {
        List<Integer> digits = toDigits(cardNumber);
        if (digits.isEmpty()) {
            return false;
        }
        
        List<Integer> doubled = doubleEveryOther(digits);
        long sum = sumDigits(doubled);
        
        return (sum % 10) == 0;
    }
}
