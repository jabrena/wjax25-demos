package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Hanoi {

    private Hanoi() {}

    public static final class Move {
        public final String from;
        public final String to;

        public Move(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Move move = (Move) o;
            return Objects.equals(from, move.from) && Objects.equals(to, move.to);
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }

        @Override
        public String toString() {
            return "Move{" + from + "->" + to + '}';
        }
    }

    public static List<Move> hanoi(int n, String from, String to, String aux) {
        List<Move> moves = new ArrayList<>();
        solve(n, from, to, aux, moves);
        return moves;
    }

    private static void solve(int n, String from, String to, String aux, List<Move> acc) {
        if (n <= 0) {
            return;
        }
        if (n == 1) {
            acc.add(new Move(from, to));
            return;
        }
        solve(n - 1, from, aux, to, acc);
        acc.add(new Move(from, to));
        solve(n - 1, aux, to, from, acc);
    }
}
