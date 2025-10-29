package info.jab.cis194.homework1;

import java.util.List;
import java.util.ArrayList;

public class Exercise2 {

    /**
     * Double every other number beginning from the right.
     * That is, the second-to-last, fourth-to-last, etc. numbers are doubled.
     * 
     * @param digits the list of digits
     * @return list with every other digit doubled from the right
     */
    public static List<Integer> doubleEveryOther(List<Integer> digits) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < digits.size(); i++) {
            int digit = digits.get(i);
            // Check if this position should be doubled (counting from the right)
            // Position should be doubled if (digits.size() - 1 - i) is odd
            // But we need to start from the right, so we check if the position from right is odd
            int positionFromRight = digits.size() - 1 - i;
            if (positionFromRight % 2 == 1) {
                result.add(digit * 2);
            } else {
                result.add(digit);
            }
        }
        
        return result;
    }
}