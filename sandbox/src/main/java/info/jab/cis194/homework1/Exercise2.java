package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.List;

public class Exercise2 {

    /**
     * Doubles every other number beginning from the right.
     * That is, the second-to-last, fourth-to-last, etc. numbers are doubled.
     * 
     * @param numbers the list of numbers to process
     * @return list with every other number doubled (from the right)
     */
    public List<Integer> doubleEveryOther(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < numbers.size(); i++) {
            int value = numbers.get(i);
            // Check if this position should be doubled (counting from the right)
            // Position should be doubled if (numbers.size() - 1 - i) is odd
            if ((numbers.size() - 1 - i) % 2 == 1) {
                result.add(value * 2);
            } else {
                result.add(value);
            }
        }
        
        return result;
    }
}