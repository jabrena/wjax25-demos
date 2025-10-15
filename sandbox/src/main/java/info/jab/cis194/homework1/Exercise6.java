package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.List;

public class Exercise6 {
    
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
     * @param n Number of disks
     * @param from Source peg
     * @param to Destination peg
     * @param temp1 First temporary peg
     * @param temp2 Second temporary peg
     * @return List of moves to solve the puzzle
     */
    public List<Move> hanoi4Pegs(Integer n, String from, String to, String temp1, String temp2) {
        List<Move> moves = new ArrayList<>();
        
        if (n <= 0) {
            return moves;
        }
        
        if (n == 1) {
            moves.add(new Move(from, to));
            return moves;
        }
        
        // For 4 pegs, we can use a more efficient algorithm
        // Move k disks to temp1, then move n-k disks to destination using temp2
        // The optimal k is approximately sqrt(2*n)
        int k = (int) Math.round(Math.sqrt(2 * n));
        if (k >= n) {
            k = n - 1;
        }
        if (k <= 0) {
            k = 1;
        }
        
        // Move k disks from source to temp1 using temp2 and destination as temporary
        moves.addAll(hanoi4Pegs(k, from, temp1, temp2, to));
        
        // Move remaining n-k disks from source to destination using temp2 as temporary
        moves.addAll(hanoi3Pegs(n - k, from, to, temp2));
        
        // Move k disks from temp1 to destination using temp2 and source as temporary
        moves.addAll(hanoi4Pegs(k, temp1, to, temp2, from));
        
        return moves;
    }
    
    /**
     * Helper method for 3-peg Hanoi (fallback when we need exactly 3 pegs).
     */
    private List<Move> hanoi3Pegs(Integer n, String from, String to, String temp) {
        List<Move> moves = new ArrayList<>();
        
        if (n <= 0) {
            return moves;
        }
        
        if (n == 1) {
            moves.add(new Move(from, to));
            return moves;
        }
        
        // Move n-1 disks from source to temporary using destination as temp
        moves.addAll(hanoi3Pegs(n - 1, from, temp, to));
        
        // Move the largest disk from source to destination
        moves.add(new Move(from, to));
        
        // Move n-1 disks from temporary to destination using source as temp
        moves.addAll(hanoi3Pegs(n - 1, temp, to, from));
        
        return moves;
    }
}