package info.jab.cis194.homework3;

import java.util.List;
import java.util.ArrayList;

/**
 * Exercise 2: Local maxima
 * 
 * A local maximum of a list is an element of the list which is strictly
 * greater than both the elements immediately before and after it.
 * 
 * The implementation iterates through the list from index 1 to size-2,
 * checking if each element is greater than both its neighbors.
 * Elements at the beginning and end of the list cannot be local maxima
 * since they don't have neighbors on both sides.
 */
public class Exercise2 {
    
    public static List<Integer> localMaxima(List<Integer> input) {
        List<Integer> result = new ArrayList<>();
        
        // A local maximum needs neighbors on both sides, so we can only check
        // elements from index 1 to size-2
        for (int i = 1; i < input.size() - 1; i++) {
            int current = input.get(i);
            int previous = input.get(i - 1);
            int next = input.get(i + 1);
            
            // Check if current element is strictly greater than both neighbors
            if (current > previous && current > next) {
                result.add(current);
            }
        }
        
        return result;
    }
}