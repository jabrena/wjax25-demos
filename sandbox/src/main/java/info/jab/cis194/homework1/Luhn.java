package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Luhn {

    private Luhn() {}

    public static List<Integer> toDigits(long n) {
        if (n <= 0) {
            return List.of();
        }
        List<Integer> digits = new ArrayList<>();
        long value = n;
        while (value > 0) {
            digits.add((int) (value % 10));
            value /= 10;
        }
        Collections.reverse(digits);
        return digits;
    }

    public static List<Integer> toDigitsRev(long n) {
        List<Integer> forward = toDigits(n);
        List<Integer> rev = new ArrayList<>(forward);
        Collections.reverse(rev);
        return rev;
    }

    public static List<Integer> doubleEveryOther(List<Integer> digits) {
        // Double every second digit from the right
        List<Integer> result = new ArrayList<>(digits);
        for (int i = result.size() - 2; i >= 0; i -= 2) {
            result.set(i, result.get(i) * 2);
        }
        return result;
    }

    public static int sumDigits(List<Integer> values) {
        int sum = 0;
        for (int v : values) {
            if (v < 10) {
                sum += v;
            } else {
                // split into digits
                int x = v;
                while (x > 0) {
                    sum += x % 10;
                    x /= 10;
                }
            }
        }
        return sum;
    }

    public static boolean isValid(long n) {
        List<Integer> digits = toDigits(n);
        List<Integer> doubled = doubleEveryOther(digits);
        int s = sumDigits(doubled);
        return s % 10 == 0 && n > 0;
    }
}
