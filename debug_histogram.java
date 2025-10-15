import java.util.*;
import info.jab.cis194.homework3.Exercise3;

public class debug_histogram {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 1, 1, 5);
        String result = Exercise3.histogram(input);
        System.out.println("Input: " + input);
        System.out.println("Output:");
        System.out.println(result);
        System.out.println("Expected:");
        System.out.println("*\n*\n*\n*\n==========\n0123456789\n");
    }
}