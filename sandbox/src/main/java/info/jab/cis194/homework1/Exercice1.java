package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Exercice1 {

    public record Move(String from, String to) {}

    private Exercice1() {}

    public static List<Integer> toDigits(int number) {
        if (number <= 0) {
            return List.of();
        }
        List<Integer> digits = new ArrayList<>();
        int n = number;
        // collect reversed
        while (n > 0) {
            digits.add(n % 10);
            n /= 10;
        }
        Collections.reverse(digits);
        return List.copyOf(digits);
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
        return List.copyOf(digits);
    }

    public static List<Integer> doubleEveryOther(List<Integer> digits) {
        if (digits.isEmpty()) {
            return List.of();
        }
        int size = digits.size();
        List<Integer> result = new ArrayList<>(size);
        // from left, but doubling every second from right means: index parity depends on size
        for (int i = 0; i < size; i++) {
            int value = digits.get(i);
            boolean shouldDouble = ((size - i) % 2 == 0); // positions counted from 1 on the right
            result.add(shouldDouble ? value * 2 : value);
        }
        return List.copyOf(result);
    }

    public static int sumDigits(List<Integer> values) {
        int sum = 0;
        for (int value : values) {
            int v = Math.abs(value);
            if (v < 10) {
                sum += v;
            } else {
                // flatten two-digit (or more) numbers
                while (v > 0) {
                    sum += v % 10;
                    v /= 10;
                }
            }
        }
        return sum;
    }

    public static boolean validate(long number) {
        if (number <= 0) {
            return false;
        }
        String s = Long.toString(number);
        List<Integer> digits = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            digits.add(s.charAt(i) - '0');
        }
        List<Integer> doubled = doubleEveryOther(digits);
        int total = sumDigits(doubled);
        return total % 10 == 0;
    }

    public static List<Move> hanoi(int n, String from, String to, String aux) {
        List<Move> moves = new ArrayList<>();
        hanoiRec(n, from, to, aux, moves);
        return List.copyOf(moves);
    }

    private static void hanoiRec(int n, String from, String to, String aux, List<Move> acc) {
        if (n <= 0) {
            return;
        }
        if (n == 1) {
            acc.add(new Move(from, to));
            return;
        }
        hanoiRec(n - 1, from, aux, to, acc);
        acc.add(new Move(from, to));
        hanoiRec(n - 1, aux, to, from, acc);
    }
}
