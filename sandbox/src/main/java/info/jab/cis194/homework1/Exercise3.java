package info.jab.cis194.homework1;

import java.util.List;

public class Exercise3 {
    
    /**
     * Calculate the sum of all digits in the list.
     * For numbers with multiple digits, sum each individual digit.
     */
    public Integer sumDigits(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(this::sumDigitsOfNumber)
                .sum();
    }
    
    /**
     * Helper method to sum the digits of a single number.
     */
    private int sumDigitsOfNumber(Integer number) {
        if (number == 0) {
            return 0;
        }
        
        int sum = 0;
        int num = Math.abs(number); // Handle negative numbers
        
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        
        return sum;
    }
}