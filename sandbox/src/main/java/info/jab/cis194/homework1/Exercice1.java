package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Exercice1 {

    private Exercice1() {}

    public static List<Integer> toDigits(long number) {
        if (number <= 0) {
            return List.of();
        }
        List<Integer> digits = new ArrayList<>();
        long n = number;
        while (n > 0) {
            digits.add(0, (int) (n % 10));
            n /= 10;
        }
        return List.copyOf(digits);
    }

    public static List<Integer> toDigitsRev(long number) {
        if (number <= 0) {
            return List.of();
        }
        List<Integer> digits = new ArrayList<>();
        long n = number;
        while (n > 0) {
            digits.add((int) (n % 10));
            n /= 10;
        }
        return List.copyOf(digits);
    }

    public static List<Integer> doubleEveryOther(List<Integer> digits) {
        if (digits.isEmpty()) {
            return List.of();
        }
        List<Integer> result = new ArrayList<>(digits);
        // Double every second digit from the right
        for (int i = result.size() - 2; i >= 0; i -= 2) {
            result.set(i, result.get(i) * 2);
        }
        return List.copyOf(result);
    }

    public static int sumDigits(List<Integer> numbers) {
        int sum = 0;
        for (int n : numbers) {
            if (n < 10) {
                sum += n;
            } else {
                int x = n;
                while (x > 0) {
                    sum += x % 10;
                    x /= 10;
                }
            }
        }
        return sum;
    }

    public static boolean validate(long number) {
        if (number <= 0) {
            return false;
        }
        List<Integer> digits = toDigits(number);
        List<Integer> transformed = doubleEveryOther(digits);
        int total = sumDigits(transformed);
        return total % 10 == 0;
    }
}
