package info.jab.cis194.homework3;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 3: Histogram
 * 
 * Creates a vertical histogram showing the frequency of each digit (0-9)
 * in the input list. The histogram displays asterisks (*) for each occurrence
 * of a digit, with each digit having its own column.
 * 
 * Implementation approach:
 * 1. Count the frequency of each digit (0-9) in the input list
 * 2. Find the maximum frequency to determine the number of rows needed
 * 3. Build the histogram row by row, from top to bottom
 * 4. For each row, check if each digit's count is >= the current row level
 * 5. Add the separator line and digit labels
 */
public class Exercise3 {
    
    /**
     * Creates a vertical histogram showing the frequency of each digit (0-9)
     * in the input list.
     * 
     * @param list the input list of integers (assumed to be between 0 and 9)
     * @return a string representation of the histogram
     */
    public String histogram(List<Integer> list) {
        // Count frequency of each digit (0-9)
        int[] counts = new int[10];
        for (int num : list) {
            if (num >= 0 && num <= 9) {
                counts[num]++;
            }
        }
        
        // Find the maximum frequency
        int maxCount = 0;
        for (int count : counts) {
            if (count > maxCount) {
                maxCount = count;
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        // Build histogram rows from top to bottom
        for (int row = maxCount; row > 0; row--) {
            StringBuilder line = new StringBuilder();
            for (int digit = 0; digit < 10; digit++) {
                if (counts[digit] >= row) {
                    line.append('*');
                } else {
                    line.append(' ');
                }
            }
            // Remove leading and trailing spaces
            String lineStr = line.toString();
            int start = 0;
            while (start < lineStr.length() && lineStr.charAt(start) == ' ') {
                start++;
            }
            int end = lineStr.length();
            while (end > start && lineStr.charAt(end - 1) == ' ') {
                end--;
            }
            if (start < end) {
                result.append(lineStr.substring(start, end));
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