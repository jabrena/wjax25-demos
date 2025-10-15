package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.List;

public class Exercise2 {

    /**
     * Double every other number beginning from the right.
     * That is, the second-to-last, fourth-to-last, etc. numbers are doubled.
     */
    public static List<Integer> doubleEveryOther(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            // Check if this position should be doubled (counting from the right)
            // If the position from the right is even (0-indexed), double it
            int positionFromRight = numbers.size() - 1 - i;
            if (positionFromRight % 2 == 1) { // second-to-last, fourth-to-last, etc.
                result.add(number * 2);
            } else {
                result.add(number);
            }
        }
        
        return result;
    }
}