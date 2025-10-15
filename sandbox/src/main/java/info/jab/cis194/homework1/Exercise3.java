package info.jab.cis194.homework1;

import java.util.List;

public class Exercise3 {

    /**
     * Calculates the sum of all digits in the given list of numbers.
     * For multi-digit numbers, each digit is summed individually.
     * 
     * @param numbers the list of numbers to sum digits from
     * @return the sum of all individual digits
     */
    public Integer sumDigits(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(this::sumDigitsOfNumber)
                .sum();
    }
    
    /**
     * Helper method to sum the digits of a single number.
     * 
     * @param number the number to sum digits from
     * @return the sum of all digits in the number
     */
    private int sumDigitsOfNumber(int number) {
        if (number == 0) {
            return 0;
        }
        
        int sum = 0;
        int n = Math.abs(number); // Handle negative numbers
        
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        
        return sum;
    }
}