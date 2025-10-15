package info.jab.cis194.homework3;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 1: Hopscotch
 * 
 * The skips function takes a list and returns a list of lists where:
 * - The first list contains all elements (every 1st element)
 * - The second list contains every 2nd element
 * - The nth list contains every nth element
 * 
 * This implementation uses a nested loop approach:
 * - For each position i (1 to list size), we collect every ith element
 * - We iterate through the original list and add elements at positions that are multiples of i
 */
public class Exercise1 {
    
    /**
     * Returns a list of lists where the nth list contains every nth element from the input.
     * 
     * @param <T> the type of elements in the list
     * @param list the input list
     * @return a list of lists where each sublist contains every nth element
     */
    public <T> List<List<T>> skips(List<T> list) {
        List<List<T>> result = new ArrayList<>();
        
        // Handle empty list case
        if (list.isEmpty()) {
            return result;
        }
        
        // For each position i from 1 to list size
        for (int i = 1; i <= list.size(); i++) {
            List<T> sublist = new ArrayList<>();
            
            // Collect every ith element (0-indexed, so we check (j + 1) % i == 0)
            for (int j = 0; j < list.size(); j++) {
                if ((j + 1) % i == 0) {
                    sublist.add(list.get(j));
                }
            }
            
            result.add(sublist);
        }
        
        return result;
    }
}