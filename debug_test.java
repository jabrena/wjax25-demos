import java.util.*;

public class debug_test {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2);
        List<Integer> result = doubleEveryOther(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + result);
        System.out.println("Expected: [1, 4]");
        
        // Debug the logic
        for (int i = 0; i < input.size(); i++) {
            int digit = input.get(i);
            int fromRight = input.size() - 1 - i;
            boolean shouldDouble = (fromRight % 2 == 1);
            System.out.println("Position " + i + " (digit " + digit + "): fromRight=" + fromRight + ", shouldDouble=" + shouldDouble);
        }
    }
    
    public static List<Integer> doubleEveryOther(List<Integer> digits) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < digits.size(); i++) {
            int digit = digits.get(i);
            // Check if this position should be doubled (counting from the right)
            // Position should be doubled if (size - 1 - i) is odd (1, 3, 5, ...)
            if ((digits.size() - 1 - i) % 2 == 1) {
                result.add(digit * 2);
            } else {
                result.add(digit);
            }
        }
        
        return result;
    }
}