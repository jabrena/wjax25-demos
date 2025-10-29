package info.jab.cis194.homework1;

import java.util.List;

public class Exercise3 {

    /**
     * Calculate the sum of all digits in the list.
     * For multi-digit numbers, sum all individual digits.
     * 
     * @param numbers the list of numbers
     * @return sum of all digits
     */
    public static int sumDigits(List<Integer> numbers) {
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
    private static int sumDigitsOfNumber(int number) {
        if (number < 0) {
            number = -number; // Handle negative numbers
        }
        
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}