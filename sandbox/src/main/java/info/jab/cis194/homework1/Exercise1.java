package info.jab.cis194.homework1;

/**
 * Exercise 1 - Basic Types and Functions
 * Based on CIS 1940 Homework 1 - Haskell Basics
 * 
 * This exercise implements basic functions for credit card validation
 * using the Luhn algorithm, adapted from Haskell to Java.
 */
public class Exercise1 {

    /**
     * Converts a number to its string representation of digits.
     * 
     * @param n the number to convert
     * @return string representation of the number's digits
     */
    public static String toDigits(int n) {
        return String.valueOf(n);
    }

    /**
     * Doubles every other element from the right in an array.
     * 
     * @param arr the input array
     * @return new array with every other element doubled from the right
     */
    public static int[] doubleEveryOther(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            // Double if position from right is odd (1-based)
            if ((arr.length - i) % 2 == 0) {
                result[i] = arr[i] * 2;
            } else {
                result[i] = arr[i];
            }
        }
        return result;
    }

    /**
     * Sums all digits in an array of numbers.
     * 
     * @param arr the input array
     * @return sum of all digits
     */
    public static int sumDigits(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += sumDigitsOfNumber(num);
        }
        return sum;
    }

    /**
     * Helper method to sum digits of a single number.
     * 
     * @param num the number
     * @return sum of its digits
     */
    private static int sumDigitsOfNumber(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    /**
     * Validates a credit card number using the Luhn algorithm.
     * 
     * @param cardNumber the credit card number
     * @return true if valid, false otherwise
     */
    public static boolean validate(long cardNumber) {
        if (cardNumber <= 0) {
            return false;
        }
        
        // Convert to array of digits
        String cardStr = String.valueOf(cardNumber);
        int[] digits = new int[cardStr.length()];
        for (int i = 0; i < cardStr.length(); i++) {
            digits[i] = Character.getNumericValue(cardStr.charAt(i));
        }
        
        // Double every other digit from the right
        int[] doubled = doubleEveryOther(digits);
        
        // Sum all digits
        int sum = sumDigits(doubled);
        
        // Check if sum is divisible by 10
        return sum % 10 == 0;
    }
}