package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Exercise5 {

    /**
     * Represents a move from one peg to another.
     */
    public static class Move {
        private final String from;
        private final String to;
        
        public Move(String from, String to) {
            this.from = from;
            this.to = to;
        }
        
        public String getFrom() {
            return from;
        }
        
        public String getTo() {
            return to;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Move move = (Move) obj;
            return Objects.equals(from, move.from) && Objects.equals(to, move.to);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(from, to);
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
    public List<Move> hanoi(Integer n, String from, String to, String temp) {
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
        
        // Move the top disc from 'from' to 'to'
        moves.add(new Move(from, to));
        
        // Move n-1 discs from 'temp' to 'to' using 'from' as temporary storage
        moves.addAll(hanoi(n - 1, temp, to, from));
        
        return moves;
    }
}