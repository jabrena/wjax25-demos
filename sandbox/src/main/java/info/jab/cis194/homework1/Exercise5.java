package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.List;

public class Exercise5 {

    /**
     * Represents a move from one peg to another.
     */
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
        public int hashCode() {
            return from.hashCode() * 31 + to.hashCode();
        }
        
        @Override
        public String toString() {
            return "(" + from + "," + to + ")";
        }
    }

    /**
     * Solve the Towers of Hanoi puzzle.
     * Move n discs from peg 'from' to peg 'to' using peg 'temp' as temporary storage.
     * 
     * @param n number of discs
     * @param from source peg
     * @param to destination peg
     * @param temp temporary peg
     * @return list of moves to solve the puzzle
     */
    public List<Move> hanoi(int n, String from, String to, String temp) {
        List<Move> moves = new ArrayList<>();
        
        if (n <= 0) {
            return moves;
        }
        
        if (n == 1) {
            // Base case: move the single disc directly
            moves.add(new Move(from, to));
        } else {
            // Recursive case:
            // 1. Move n-1 discs from 'from' to 'temp' using 'to' as temporary storage
            moves.addAll(hanoi(n - 1, from, temp, to));
            
            // 2. Move the top disc from 'from' to 'to'
            moves.add(new Move(from, to));
            
            // 3. Move n-1 discs from 'temp' to 'to' using 'from' as temporary storage
            moves.addAll(hanoi(n - 1, temp, to, from));
        }
        
        return moves;
    }
}