package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Exercise1 {

    private Exercise1() {}

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
        if (digits == null || digits.isEmpty()) {
            return List.of();
        }
        List<Integer> result = new ArrayList<>(digits);
        // Double every second digit starting from the rightmost (i.e., index from end)
        for (int i = result.size() - 2; i >= 0; i -= 2) {
            result.set(i, result.get(i) * 2);
        }
        return List.copyOf(result);
    }

    public static int sumDigits(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (Integer value : numbers) {
            int v = value == null ? 0 : value;
            v = Math.abs(v);
            if (v < 10) {
                sum += v;
            } else {
                while (v > 0) {
                    sum += v % 10;
                    v /= 10;
                }
            }
        }
        return sum;
    }

    public static boolean validate(long creditCardNumber) {
        if (creditCardNumber <= 0) {
            return false;
        }
        List<Integer> digits = toDigits(creditCardNumber);
        List<Integer> doubled = doubleEveryOther(digits);
        int checksum = sumDigits(doubled);
        return checksum % 10 == 0;
    }

    public static record Move(String from, String to) {
        public Move {
            Objects.requireNonNull(from, "from");
            Objects.requireNonNull(to, "to");
        }
    }

    public static List<Move> hanoi(int numDisks, String from, String to, String aux) {
        if (numDisks <= 0) {
            return List.of();
        }
        List<Move> moves = new ArrayList<>();
        hanoiRecursive(numDisks, from, to, aux, moves);
        return List.copyOf(moves);
    }

    private static void hanoiRecursive(int n, String from, String to, String aux, List<Move> acc) {
        if (n == 1) {
            acc.add(new Move(from, to));
            return;
        }
        hanoiRecursive(n - 1, from, aux, to, acc);
        acc.add(new Move(from, to));
        hanoiRecursive(n - 1, aux, to, from, acc);
    }
}
