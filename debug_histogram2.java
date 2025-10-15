import java.util.*;
import info.jab.cis194.homework3.Exercise3;

public class debug_histogram2 {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 1, 1, 5);
        
        // Count frequency of each digit (0-9)
        int[] counts = new int[10];
        for (int num : input) {
            if (num >= 0 && num <= 9) {
                counts[num]++;
            }
        }
        
        System.out.println("Input: " + input);
        System.out.println("Counts: " + Arrays.toString(counts));
        
        // Find maximum frequency to determine height
        int maxCount = 0;
        for (int count : counts) {
            maxCount = Math.max(maxCount, count);
        }
        
        System.out.println("Max count: " + maxCount);
        
        String result = Exercise3.histogram(input);
        System.out.println("Output:");
        System.out.println(result);
    }
}