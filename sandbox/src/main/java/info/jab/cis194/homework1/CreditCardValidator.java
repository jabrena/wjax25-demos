package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CreditCardValidator {

    private CreditCardValidator() {}

    public static List<Integer> toDigits(long number) {
        if (number <= 0) {
            return List.of();
        }
        List<Integer> result = new ArrayList<>();
        long n = number;
        // Build reversed then reverse at end for efficiency
        while (n > 0) {
            int digit = (int) (n % 10);
            result.add(digit);
            n /= 10;
        }
        Collections.reverse(result);
        return result;
    }

    public static List<Integer> toDigitsRev(long number) {
        List<Integer> digits = toDigits(number);
        List<Integer> copy = new ArrayList<>(digits);
        Collections.reverse(copy);
        return copy;
    }

    public static List<Integer> doubleEveryOther(List<Integer> digits) {
        // Double every second digit from the right
        int size = digits.size();
        List<Integer> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            int indexFromRight = size - 1 - i;
            int value = digits.get(i);
            // if indexFromRight is odd => this is every second from right
            if ((indexFromRight % 2) == 1) {
                result.add(value * 2);
            } else {
                result.add(value);
            }
        }
        return result;
    }

    public static int sumDigits(List<Integer> values) {
        int sum = 0;
        for (int value : values) {
            if (value < 10) {
                sum += value;
            } else {
                // split two-digit numbers into digits and sum
                sum += value / 10;
                sum += value % 10;
            }
        }
        return sum;
    }

    public static boolean isValid(long number) {
        List<Integer> digits = toDigits(number);
        List<Integer> doubled = doubleEveryOther(digits);
        int checksum = sumDigits(doubled);
        return (checksum % 10) == 0;
    }
}
