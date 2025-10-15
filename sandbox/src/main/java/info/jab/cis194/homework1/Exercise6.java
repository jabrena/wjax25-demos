package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.List;

public class Exercise6 {

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
     * Solve the Towers of Hanoi puzzle with 4 pegs.
     * This uses the Frame-Stewart algorithm for optimal solution.
     * 
     * @param n number of discs
     * @param from source peg
     * @param to destination peg
     * @param temp1 first temporary peg
     * @param temp2 second temporary peg
     * @return list of moves to solve the puzzle
     */
    public List<Move> hanoi4(int n, String from, String to, String temp1, String temp2) {
        List<Move> moves = new ArrayList<>();
        
        if (n <= 0) {
            return moves;
        }
        
        if (n == 1) {
            // Base case: move the single disc directly
            moves.add(new Move(from, to));
        } else if (n == 2) {
            // For 2 discs, use 3-peg algorithm
            moves.add(new Move(from, temp1));
            moves.add(new Move(from, to));
            moves.add(new Move(temp1, to));
        } else {
            // For more discs, use Frame-Stewart algorithm
            // Move k discs to temp1, then move remaining n-k discs to destination
            // using the remaining 3 pegs, then move k discs from temp1 to destination
            int k = (int) Math.round(n - Math.sqrt(2 * n + 1) + 1);
            
            // Move k discs from 'from' to 'temp1' using 'temp2' and 'to' as temporary
            moves.addAll(hanoi4(k, from, temp1, temp2, to));
            
            // Move remaining n-k discs from 'from' to 'to' using 'temp1' and 'temp2' as temporary
            moves.addAll(hanoi3(n - k, from, to, temp1, temp2));
            
            // Move k discs from 'temp1' to 'to' using 'temp2' and 'from' as temporary
            moves.addAll(hanoi4(k, temp1, to, temp2, from));
        }
        
        return moves;
    }
    
    /**
     * Helper method to solve 3-peg Towers of Hanoi.
     * 
     * @param n number of discs
     * @param from source peg
     * @param to destination peg
     * @param temp1 first temporary peg
     * @param temp2 second temporary peg (unused in 3-peg version)
     * @return list of moves
     */
    private List<Move> hanoi3(int n, String from, String to, String temp1, String temp2) {
        List<Move> moves = new ArrayList<>();
        
        if (n <= 0) {
            return moves;
        }
        
        if (n == 1) {
            moves.add(new Move(from, to));
        } else {
            // Move n-1 discs from 'from' to 'temp1' using 'to' as temporary
            moves.addAll(hanoi3(n - 1, from, temp1, to, temp2));
            
            // Move the top disc from 'from' to 'to'
            moves.add(new Move(from, to));
            
            // Move n-1 discs from 'temp1' to 'to' using 'from' as temporary
            moves.addAll(hanoi3(n - 1, temp1, to, from, temp2));
        }
        
        return moves;
    }
}