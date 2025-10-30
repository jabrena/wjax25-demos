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
            int d = (int) (n % 10);
            digits.add(d);
            n /= 10;
        }
        Collections.reverse(digits);
        return List.copyOf(digits);
    }

    public static List<Integer> toDigits(int number) {
        return toDigits((long) number);
    }

    public static List<Integer> toDigitsRev(long number) {
        if (number <= 0) {
            return List.of();
        }
        List<Integer> digits = new ArrayList<>();
        long n = number;
        while (n > 0) {
            int d = (int) (n % 10);
            digits.add(d);
            n /= 10;
        }
        return List.copyOf(digits);
    }

    public static List<Integer> toDigitsRev(int number) {
        return toDigitsRev((long) number);
    }

    // Double every other digit starting from the right
    public static List<Integer> doubleEveryOther(List<Integer> digits) {
        int size = digits.size();
        List<Integer> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            int fromRightIndex = size - 1 - i;
            int value = digits.get(i);
            // If position from right is even (0-based), it's the rightmost digit; we double the next one
            boolean shouldDouble = (fromRightIndex % 2 == 1);
            result.add(shouldDouble ? value * 2 : value);
        }
        return List.copyOf(result);
    }

    public static int sumDigits(List<Integer> numbers) {
        int sum = 0;
        for (int value : numbers) {
            if (value < 10) {
                sum += value;
            } else {
                int v = value;
                while (v > 0) {
                    sum += v % 10;
                    v /= 10;
                }
            }
        }
        return sum;
    }

    public static boolean validate(long number) {
        List<Integer> digits = toDigits(number);
        List<Integer> doubled = doubleEveryOther(digits);
        int checksum = sumDigits(doubled);
        return checksum % 10 == 0;
    }
}
