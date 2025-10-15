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
            // If the position from the right is even (0-indexed), then double it
            int positionFromRight = digits.size() - 1 - i;
            if (positionFromRight % 2 == 1) { // second-to-last, fourth-to-last, etc.
                result.add(digit * 2);
            } else {
                result.add(digit);
            }
        }
        
        return result;
    }
}