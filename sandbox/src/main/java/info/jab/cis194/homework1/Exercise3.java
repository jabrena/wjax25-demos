package info.jab.cis194.homework1;

import java.util.List;

public class Exercise3 {

    /**
     * Calculate the sum of all digits in the list.
     * For numbers with multiple digits, sum each digit individually.
     * 
     * @param numbers the list of numbers
     * @return sum of all digits
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
     * @return sum of digits
     */
    private Integer sumDigitsOfNumber(Integer number) {
        int sum = 0;
        int n = Math.abs(number); // Handle negative numbers
        
        if (n == 0) {
            return 0;
        }
        
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        
        return sum;
    }
}