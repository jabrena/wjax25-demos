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
}
