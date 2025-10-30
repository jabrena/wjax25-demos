package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.List;

public final class Exercice2 {

    public record Move(String from, String to) {}

    private Exercice2() {}

    public static List<Move> hanoi(int n, String source, String target, String auxiliary) {
        List<Move> moves = new ArrayList<>();
        solve(n, source, target, auxiliary, moves);
        return moves;
    }

    private static void solve(int n, String source, String target, String auxiliary, List<Move> acc) {
        if (n <= 0) {
            return;
        }
        if (n == 1) {
            acc.add(new Move(source, target));
            return;
        }
        solve(n - 1, source, auxiliary, target, acc);
        acc.add(new Move(source, target));
        solve(n - 1, auxiliary, target, source, acc);
    }
}
