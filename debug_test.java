import java.util.*;
import info.jab.cis194.homework3.Exercise1;

public class debug_test {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(2, 9, 5, 6, 1);
        List<List<Integer>> result = Exercise1.skips(input);
        System.out.println("Input: " + input);
        for (int i = 0; i < result.size(); i++) {
            System.out.println("Position " + i + ": " + result.get(i));
        }
    }
}