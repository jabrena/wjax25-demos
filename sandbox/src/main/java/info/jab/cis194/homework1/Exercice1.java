package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Exercice1 {

    private Exercice1() {}

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
}
