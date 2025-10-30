package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.List;

public final class Hanoi {

    private Hanoi() {}

    public record Move(String from, String to) {}

    public static List<Move> solve(int n, String from, String to, String spare) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be >= 0");
        }
        List<Move> moves = new ArrayList<>();
        solveRec(n, from, to, spare, moves);
        return moves;
    }

    private static void solveRec(int n, String from, String to, String spare, List<Move> acc) {
        if (n == 0) {
            return;
        }
        // Move n-1 from 'from' to 'spare' using 'to' as auxiliary
        solveRec(n - 1, from, spare, to, acc);
        // Move largest disk from 'from' to 'to'
        acc.add(new Move(from, to));
        // Move n-1 from 'spare' to 'to' using 'from' as auxiliary
        solveRec(n - 1, spare, to, from, acc);
    }
}
