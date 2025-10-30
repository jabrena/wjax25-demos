package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Exercice1 {

    private Exercice1() {}

    public record Move(String from, String to) {}

    public static List<Integer> toDigits(int number) {
        if (number <= 0) {
            return List.of();
        }
        List<Integer> digits = new ArrayList<>();
        int n = number;
        while (n > 0) {
            digits.add(n % 10);
            n /= 10;
        }
        Collections.reverse(digits);
        return digits;
    }

    public static List<Integer> toDigitsRev(int number) {
        if (number <= 0) {
            return List.of();
        }
        List<Integer> digits = new ArrayList<>();
        int n = number;
        while (n > 0) {
            digits.add(n % 10);
            n /= 10;
        }
        return digits;
    }

    public static List<Integer> doubleEveryOther(List<Integer> digits) {
        if (digits.isEmpty()) {
            return List.of();
        }
        List<Integer> reversed = new ArrayList<>(digits);
        Collections.reverse(reversed);

        List<Integer> processed = new ArrayList<>(reversed.size());
        for (int i = 0; i < reversed.size(); i++) {
            int value = reversed.get(i);
            if ((i % 2) == 1) {
                processed.add(value * 2);
            } else {
                processed.add(value);
            }
        }

        Collections.reverse(processed);
        return processed;
    }

    public static int sumDigits(List<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            int n = Math.abs(number);
            if (n < 10) {
                total += n;
            } else {
                while (n > 0) {
                    total += (n % 10);
                    n /= 10;
                }
            }
        }
        return total;
    }

    public static boolean validate(long number) {
        if (number <= 0) {
            return false;
        }
        // Build digits from the long value
        if (number > Integer.MAX_VALUE) {
            // handle via string to be safe with very long numbers
            String s = Long.toString(number);
            List<Integer> digits = new ArrayList<>(s.length());
            for (int i = 0; i < s.length(); i++) {
                digits.add(s.charAt(i) - '0');
            }
            int checksum = sumDigits(doubleEveryOther(digits));
            return checksum % 10 == 0;
        } else {
            List<Integer> digits = toDigits((int) number);
            int checksum = sumDigits(doubleEveryOther(digits));
            return checksum % 10 == 0;
        }
    }

    public static List<Move> hanoi(int n, String from, String to, String temp) {
        List<Move> moves = new ArrayList<>();
        solveHanoi(n, from, to, temp, moves);
        return moves;
    }

    private static void solveHanoi(int n, String from, String to, String temp, List<Move> acc) {
        if (n <= 0) {
            return;
        }
        if (n == 1) {
            acc.add(new Move(from, to));
            return;
        }
        solveHanoi(n - 1, from, temp, to, acc);
        acc.add(new Move(from, to));
        solveHanoi(n - 1, temp, to, from, acc);
    }
}
