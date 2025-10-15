import java.util.*;

public class luhn_test {
    public static void main(String[] args) {
        long cardNumber = 4012888888881882L;
        System.out.println("Testing card number: " + cardNumber);
        
        List<Integer> digits = toDigits((int) cardNumber);
        System.out.println("Digits: " + digits);
        
        List<Integer> doubled = doubleEveryOther(digits);
        System.out.println("Doubled: " + doubled);
        
        int sum = sumDigits(doubled);
        System.out.println("Sum: " + sum);
        
        boolean valid = sum % 10 == 0;
        System.out.println("Valid: " + valid);
    }
    
    public static List<Integer> toDigits(int n) {
        List<Integer> digits = new ArrayList<>();
        if (n == 0) {
            digits.add(0);
            return digits;
        }
        
        while (n > 0) {
            digits.add(0, n % 10);
            n /= 10;
        }
        
        return digits;
    }
    
    public static List<Integer> doubleEveryOther(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            if ((list.size() - 1 - i) % 2 == 1) {
                value *= 2;
            }
            result.add(value);
        }
        return result;
    }
    
    public static int sumDigits(List<Integer> list) {
        return list.stream()
                .mapToInt(n -> toDigits(n).stream().mapToInt(Integer::intValue).sum())
                .sum();
    }
}
