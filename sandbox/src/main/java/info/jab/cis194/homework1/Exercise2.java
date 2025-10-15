package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.List;

public class Exercise2 {

    /**
     * Double every other number beginning from the right.
     * That is, the second-to-last, fourth-to-last, etc. numbers are doubled.
     * 
     * @param digits list of digits
     * @return list with every other digit doubled from the right
     */
    public List<Integer> doubleEveryOther(List<Integer> digits) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < digits.size(); i++) {
            int digit = digits.get(i);
            // Check if this position should be doubled (counting from the right)
            // Position should be doubled if (size - 1 - i) is odd (1, 3, 5, ...)
            // This means we double positions 1, 3, 5, ... from the left
            if ((digits.size() - 1 - i) % 2 == 1) {
                result.add(digit * 2);
            } else {
                result.add(digit);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Exercise2 ex2 = new Exercise2();
        java.util.List<Integer> input = java.util.Arrays.asList(1, 2);
        java.util.List<Integer> result = ex2.doubleEveryOther(input);
        System.out.println("Input: " + input);
        System.out.println("Result: " + result);
        
        // Debug the logic
        for (int i = 0; i < input.size(); i++) {
            int digit = input.get(i);
            int posFromRight = input.size() - 1 - i;
            boolean shouldDouble = posFromRight % 2 == 1;
            System.out.println("i=" + i + ", digit=" + digit + ", posFromRight=" + posFromRight + ", shouldDouble=" + shouldDouble);
        }
    }
}