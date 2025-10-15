package info.jab.cis194.homework3;

import java.util.List;
import java.util.Arrays;

/**
 * Exercise 3: Histogram
 * 
 * Takes a list of Integers between 0 and 9 (inclusive) and outputs
 * a vertical histogram showing how many of each number were in the input list.
 * 
 * The implementation:
 * 1. Counts the frequency of each digit (0-9) in the input list
 * 2. Finds the maximum frequency to determine the height of the histogram
 * 3. Builds the histogram row by row, from top to bottom
 * 4. Each row shows '*' for digits that have at least that frequency
 * 5. Adds the separator line and digit labels at the bottom
 */
public class Exercise3 {
    
    public static String histogram(List<Integer> input) {
        // Count frequency of each digit (0-9)
        int[] counts = new int[10];
        for (int num : input) {
            if (num >= 0 && num <= 9) {
                counts[num]++;
            }
        }
        
        // Height should be the total number of elements
        int maxCount = input.size();
        
        // Build histogram
        StringBuilder result = new StringBuilder();
        
        // Build rows from top to bottom
        for (int row = maxCount; row > 0; row--) {
            for (int digit = 0; digit < 10; digit++) {
                if (counts[digit] >= row) {
                    result.append('*');
                } else {
                    result.append(' ');
                }
            }
            result.append('\n');
        }
        
        // Add separator line
        result.append("==========\n");
        
        // Add digit labels
        result.append("0123456789\n");
        
        return result.toString();
    }
}