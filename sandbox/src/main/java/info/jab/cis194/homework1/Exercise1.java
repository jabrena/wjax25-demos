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
            digits.add((int) (n % 10));
            n /= 10;
        }
        Collections.reverse(digits);
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
        int size = digits.size();
        List<Integer> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            int fromRightIndex = size - 1 - i;
            int value = digits.get(i);
            if (fromRightIndex % 2 == 1) {
                result.add(value * 2);
            } else {
                result.add(value);
            }
        }
        return List.copyOf(result);
    }

    public static int sumDigits(List<Integer> numbers) {
        int sum = 0;
        for (int n : numbers) {
            n = Math.abs(n);
            if (n == 0) {
                continue;
            }
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
        }
        return sum;
    }

    public static boolean validate(long creditCardNumber) {
        if (creditCardNumber <= 0) return false;
        List<Integer> digits = toDigits(creditCardNumber);
        List<Integer> doubled = doubleEveryOther(digits);
        int checksum = sumDigits(doubled);
        return checksum % 10 == 0;
    }

    public record Move(char fromPeg, char toPeg) {
        public Move {
            if (!isPeg(fromPeg) || !isPeg(toPeg)) {
                throw new IllegalArgumentException("Peg must be one of a, b, c");
            }
        }
        private static boolean isPeg(char c) {
            return c == 'a' || c == 'b' || c == 'c';
        }
    }

    public static List<Move> hanoi(int nDisks, char from, char via, char to) {
        if (nDisks <= 0) {
            return List.of();
        }
        List<Move> moves = new ArrayList<>();
        solveHanoi(nDisks, from, via, to, moves);
        return List.copyOf(moves);
    }

    private static void solveHanoi(int n, char from, char via, char to, List<Move> acc) {
        if (n == 0) return;
        solveHanoi(n - 1, from, to, via, acc);
        acc.add(new Move(from, to));
        solveHanoi(n - 1, via, from, to, acc);
    }
}
