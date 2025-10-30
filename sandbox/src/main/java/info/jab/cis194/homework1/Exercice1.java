package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Exercice1 {

    private Exercice1() {}

    public static List<Integer> toDigits(int n) {
        if (n <= 0) {
            return List.of();
        }
        List<Integer> digits = new ArrayList<>();
        int value = n;
        while (value > 0) {
            digits.add(value % 10);
            value /= 10;
        }
        Collections.reverse(digits);
        return List.copyOf(digits);
    }

    public static List<Integer> toDigitsRev(int n) {
        if (n <= 0) {
            return List.of();
        }
        List<Integer> digits = new ArrayList<>();
        int value = n;
        while (value > 0) {
            digits.add(value % 10);
            value /= 10;
        }
        return List.copyOf(digits);
    }
}
