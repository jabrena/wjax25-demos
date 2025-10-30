package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.List;

public final class Exercice1 {

    private Exercice1() {
    }

    public static int[] toDigits(long number) {
        if (number <= 0) {
            return new int[0];
        }
        List<Integer> digits = new ArrayList<>();
        long n = number;
        // collect in reverse order first
        while (n > 0) {
            digits.add((int) (n % 10));
            n /= 10;
        }
        // reverse to normal order
        int[] result = new int[digits.size()];
        for (int i = 0; i < digits.size(); i++) {
            result[i] = digits.get(digits.size() - 1 - i);
        }
        return result;
    }

    public static int[] toDigits(int number) {
        return toDigits((long) number);
    }

    public static int[] toDigitsRev(long number) {
        if (number <= 0) {
            return new int[0];
        }
        List<Integer> digits = new ArrayList<>();
        long n = number;
        while (n > 0) {
            digits.add((int) (n % 10));
            n /= 10;
        }
        int[] result = new int[digits.size()];
        for (int i = 0; i < digits.size(); i++) {
            result[i] = digits.get(i);
        }
        return result;
    }

    public static int[] toDigitsRev(int number) {
        return toDigitsRev((long) number);
    }

    public static int[] doubleEveryOther(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[0];
        }
        int[] result = new int[digits.length];
        // double every second digit from the right
        for (int i = digits.length - 1, posFromRight = 0; i >= 0; i--, posFromRight++) {
            int value = digits[i];
            if (posFromRight % 2 == 1) { // every other starting from second-from-right
                value *= 2;
            }
            result[i] = value;
        }
        return result;
    }

    public static int sumDigits(int[] numbers) {
        int sum = 0;
        if (numbers == null) {
            return 0;
        }
        for (int number : numbers) {
            if (number < 10) {
                sum += Math.max(number, 0);
            } else {
                int n = number;
                while (n > 0) {
                    sum += n % 10;
                    n /= 10;
                }
            }
        }
        return sum;
    }

    public static boolean validate(long creditCardNumber) {
        int[] digits = toDigits(creditCardNumber);
        int[] doubled = doubleEveryOther(digits);
        int checksum = sumDigits(doubled);
        return checksum % 10 == 0;
    }
}
