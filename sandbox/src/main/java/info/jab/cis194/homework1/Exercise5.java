package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.List;

public class Exercise5 {

    public static class Move {
        public final String from;
        public final String to;
        
        public Move(String from, String to) {
            this.from = from;
            this.to = to;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Move move = (Move) obj;
            return from.equals(move.from) && to.equals(move.to);
        }
        
        @Override
        public String toString() {
            return "(" + from + "," + to + ")";
        }
    }

    /**
     * Solve the Towers of Hanoi puzzle.
     * Returns a list of moves to transfer n discs from the first peg to the second peg.
     */
    public static List<Move> hanoi(int n, String from, String to, String temp) {
        List<Move> moves = new ArrayList<>();
        
        if (n <= 0) {
            return moves;
        }
        
        if (n == 1) {
            moves.add(new Move(from, to));
            return moves;
        }
        
        // Move n-1 discs from 'from' to 'temp' using 'to' as temporary storage
        moves.addAll(hanoi(n - 1, from, temp, to));
        
        // Move the largest disc from 'from' to 'to'
        moves.add(new Move(from, to));
        
        // Move n-1 discs from 'temp' to 'to' using 'from' as temporary storage
        moves.addAll(hanoi(n - 1, temp, to, from));
        
        return moves;
    }
}