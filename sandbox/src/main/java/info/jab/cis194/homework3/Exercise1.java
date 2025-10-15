package info.jab.cis194.homework3;

import java.util.List;
import java.util.ArrayList;

/**
 * Exercise 1: Hopscotch (skips function)
 * 
 * This function returns a list of lists where:
 * - The first list is the same as the input list
 * - The second list contains every second element from the input list
 * - The nth list contains every nth element from the input list
 * 
 * The implementation uses a nested loop approach:
 * - Outer loop iterates through each position (0 to list.size()-1)
 * - Inner loop collects every (i+1)th element starting from position i
 * - This creates the hopscotch pattern where each sublist skips elements
 */
public class Exercise1 {
    
    public static <T> List<List<T>> skips(List<T> input) {
        List<List<T>> result = new ArrayList<>();
        
        for (int i = 0; i < input.size(); i++) {
            List<T> sublist = new ArrayList<>();
            for (int j = i; j < input.size(); j += (i + 1)) {
                sublist.add(input.get(j));
            }
            result.add(sublist);
        }
        
        return result;
    }
}