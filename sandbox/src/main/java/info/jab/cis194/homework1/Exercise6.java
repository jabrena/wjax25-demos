package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.List;

public class Exercise6 {

    /**
     * Solves the Towers of Hanoi puzzle with four pegs using an optimized algorithm.
     * 
     * @param n number of disks
     * @param from source peg
     * @param to destination peg
     * @param aux1 first auxiliary peg
     * @param aux2 second auxiliary peg
     * @return list of moves to solve the puzzle
     */
    public List<Move> hanoi4(Integer n, String from, String to, String aux1, String aux2) {
        List<Move> moves = new ArrayList<>();
        
        if (n <= 0) {
            return moves;
        }
        
        hanoi4Helper(n, from, to, aux1, aux2, moves);
        return moves;
    }
    
    /**
     * Helper method to recursively solve the four-peg Towers of Hanoi puzzle.
     * Uses an optimized algorithm that tries to minimize the number of moves.
     * 
     * @param n number of disks
     * @param from source peg
     * @param to destination peg
     * @param aux1 first auxiliary peg
     * @param aux2 second auxiliary peg
     * @param moves list to store moves
     */
    private void hanoi4Helper(Integer n, String from, String to, String aux1, String aux2, List<Move> moves) {
        if (n == 1) {
            // Base case: move the top disk from source to destination
            moves.add(new Move(from, to));
        } else if (n == 2) {
            // For 2 disks, use the 3-peg algorithm with aux1 as temporary
            moves.add(new Move(from, aux1));
            moves.add(new Move(from, to));
            moves.add(new Move(aux1, to));
        } else {
            // For more than 2 disks, use the optimized 4-peg algorithm
            // Move k disks to aux1 using aux2 as temporary
            int k = n / 2; // Optimal split point
            hanoi4Helper(k, from, aux1, aux2, to, moves);
            
            // Move the remaining n-k disks to aux2 using the 3-peg algorithm
            hanoi3Helper(n - k, from, to, aux2, moves);
            
            // Move k disks from aux1 to destination using aux2 as temporary
            hanoi4Helper(k, aux1, to, aux2, from, moves);
        }
    }
    
    /**
     * Helper method for 3-peg Towers of Hanoi (used as a subroutine).
     * 
     * @param n number of disks
     * @param from source peg
     * @param to destination peg
     * @param aux auxiliary peg
     * @param moves list to store moves
     */
    private void hanoi3Helper(Integer n, String from, String to, String aux, List<Move> moves) {
        if (n == 1) {
            moves.add(new Move(from, to));
        } else {
            hanoi3Helper(n - 1, from, aux, to, moves);
            moves.add(new Move(from, to));
            hanoi3Helper(n - 1, aux, to, from, moves);
        }
    }
    
    /**
     * Represents a move in the Towers of Hanoi puzzle.
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
}