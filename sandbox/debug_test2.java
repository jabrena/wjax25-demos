import java.util.*;

public class debug_test2 {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Input: " + input);
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            int value = input.get(i);
            int positionFromRight = input.size() - 1 - i;
            System.out.println("i=" + i + ", value=" + value + ", positionFromRight=" + positionFromRight + ", shouldDouble=" + (positionFromRight % 2 == 1));
            if (positionFromRight % 2 == 1) {
                value *= 2;
            }
            result.add(value);
        }
        System.out.println("Result: " + result);
        System.out.println("Expected: [2, 2, 6, 8, 5]");
    }
}
