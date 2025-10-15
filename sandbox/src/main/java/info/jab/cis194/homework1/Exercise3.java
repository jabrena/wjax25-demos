package info.jab.cis194.homework1;

import java.util.List;

public class Exercise3 {

    /**
     * Calculate the sum of all digits in a list of integers.
     * For multi-digit numbers, each digit is summed individually.
     * 
     * @param numbers list of integers
     * @return sum of all individual digits
     */
    public Integer sumDigits(List<Integer> numbers) {
        int sum = 0;
        
        for (Integer number : numbers) {
            sum += sumDigitsOfNumber(number);
        }
        
        return sum;
    }
    
    /**
     * Helper method to sum the digits of a single number.
     * 
     * @param number the number to sum digits of
     * @return sum of individual digits
     */
    private Integer sumDigitsOfNumber(Integer number) {
        int sum = 0;
        int n = Math.abs(number); // Handle negative numbers
        
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        
        return sum;
    }
}