package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 1 - Basic arithmetic and function definitions
 * Based on CIS 1940 Homework 1 exercises
 */
public class Exercise1 {

    /**
     * Convert a number to its individual digits
     */
    public static List<Integer> toDigits(long n) {
        List<Integer> digits = new ArrayList<>();
        if (n == 0) {
            digits.add(0);
            return digits;
        }
        
        while (n > 0) {
            digits.add(0, (int)(n % 10));
            n /= 10;
        }
        
        return digits;
    }

    /**
     * Double every other element from the right (starting with the rightmost)
     */
    public static List<Integer> doubleEveryOther(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            // Double if index is odd (counting from right, 0-based)
            if ((list.size() - 1 - i) % 2 == 1) {
                value *= 2;
            }
            result.add(value);
        }
        return result;
    }

    /**
     * Sum all digits in a list of numbers
     */
    public static int sumDigits(List<Integer> list) {
        return list.stream()
                .mapToInt(n -> toDigits(n).stream().mapToInt(Integer::intValue).sum())
                .sum();
    }

    /**
     * Validate a credit card number using Luhn algorithm
     */
    public static boolean validate(long cardNumber) {
        List<Integer> digits = toDigits(cardNumber);
        List<Integer> doubled = doubleEveryOther(digits);
        int sum = sumDigits(doubled);
        return sum % 10 == 0;
    }

    /**
     * Tower of Hanoi puzzle solver
     */
    public static List<Move> hanoi(int n, int from, int to) {
        List<Move> moves = new ArrayList<>();
        if (n == 0) {
            return moves;
        }
        
        int aux = 6 - from - to; // Calculate auxiliary peg
        moves.addAll(hanoi(n - 1, from, aux));
        moves.add(new Move(from, to));
        moves.addAll(hanoi(n - 1, aux, to));
        
        return moves;
    }

    /**
     * Represents a move in the Tower of Hanoi puzzle
     */
    public static class Move {
        private final int from;
        private final int to;

        public Move(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Move move = (Move) obj;
            return from == move.from && to == move.to;
        }

        @Override
        public int hashCode() {
            return java.util.Objects.hash(from, to);
        }

        @Override
        public String toString() {
            return "Move{" + from + " -> " + to + "}";
        }
    }
}