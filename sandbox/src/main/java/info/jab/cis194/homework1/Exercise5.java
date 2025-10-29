package info.jab.cis194.homework1;

import java.util.List;
import java.util.ArrayList;

public class Exercise5 {

    /**
     * Represents a move in the Towers of Hanoi puzzle.
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
     * 
     * @param n number of discs
     * @param from source peg
     * @param to destination peg
     * @param temp temporary peg
     * @return list of moves to solve the puzzle
     */
    public static List<Move> hanoi(int n, String from, String to, String temp) {
        List<Move> moves = new ArrayList<>();
        hanoiHelper(n, from, to, temp, moves);
        return moves;
    }
    
    /**
     * Helper method to recursively solve the Towers of Hanoi puzzle.
     * 
     * @param n number of discs
     * @param from source peg
     * @param to destination peg
     * @param temp temporary peg
     * @param moves list to collect moves
     */
    private static void hanoiHelper(int n, String from, String to, String temp, List<Move> moves) {
        if (n <= 0) {
            return;
        }
        
        // Move n-1 discs from source to temporary using destination as temp
        hanoiHelper(n - 1, from, temp, to, moves);
        
        // Move the top disc from source to destination
        moves.add(new Move(from, to));
        
        // Move n-1 discs from temporary to destination using source as temp
        hanoiHelper(n - 1, temp, to, from, moves);
    }
}