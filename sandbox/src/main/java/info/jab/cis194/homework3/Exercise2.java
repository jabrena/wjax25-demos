package info.jab.cis194.homework3;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 2: Local maxima
 * 
 * A local maximum of a list is an element which is strictly greater than both
 * the elements immediately before and after it. This function finds all local
 * maxima in the input list and returns them in order.
 * 
 * Implementation approach:
 * - Iterate through the list from index 1 to size-2 (inclusive)
 * - For each element at index i, check if it's greater than both elements at i-1 and i+1
 * - If so, add it to the result list
 * - Edge cases: lists with less than 3 elements have no local maxima
 */
public class Exercise2 {
    
    /**
     * Finds all local maxima in the input list.
     * A local maximum is an element that is strictly greater than both
     * the elements immediately before and after it.
     * 
     * @param list the input list of integers
     * @return a list containing all local maxima in order
     */
    public List<Integer> localMaxima(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        
        // Need at least 3 elements to have a local maximum
        if (list.size() < 3) {
            return result;
        }
        
        // Check elements from index 1 to size-2 (inclusive)
        for (int i = 1; i < list.size() - 1; i++) {
            int current = list.get(i);
            int previous = list.get(i - 1);
            int next = list.get(i + 1);
            
            // Check if current element is strictly greater than both neighbors
            if (current > previous && current > next) {
                result.add(current);
            }
        }
        
        return result;
    }
}