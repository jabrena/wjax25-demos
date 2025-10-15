package info.jab.cis194.homework1;

import java.util.List;

public class Exercise3 {

    /**
     * Calculate the sum of all digits in the list.
     * For multi-digit numbers, sum their individual digits.
     */
    public static int sumDigits(List<Integer> numbers) {
        int sum = 0;
        
        for (int number : numbers) {
            // Sum all digits of the number
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
        }
        
        return sum;
    }
}