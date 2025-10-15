package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.List;

public class Exercise2 {

    /**
     * Double every other number beginning from the right.
     * That is, the second-to-last, fourth-to-last, etc. numbers are doubled.
     * 
     * @param digits the list of digits
     * @return list with every other digit doubled (from the right)
     */
    public List<Integer> doubleEveryOther(List<Integer> digits) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < digits.size(); i++) {
            int digit = digits.get(i);
            // Check if this position should be doubled (counting from the right)
            // Position from right: (digits.size() - 1 - i)
            // Double if position from right is odd (1, 3, 5, ...)
            // But we need to double every other starting from the right, so positions 1, 3, 5, ... from right
            if ((digits.size() - 1 - i) % 2 == 1) {
                result.add(digit * 2);
            } else {
                result.add(digit);
            }
        }
        
        return result;
    }
}