package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.List;

public class Exercise5 {

    /**
     * Solves the Towers of Hanoi puzzle.
     * 
     * @param n number of disks
     * @param from source peg
     * @param to destination peg
     * @param aux auxiliary peg
     * @return list of moves to solve the puzzle
     */
    public List<Move> hanoi(Integer n, String from, String to, String aux) {
        List<Move> moves = new ArrayList<>();
        
        if (n <= 0) {
            return moves;
        }
        
        hanoiHelper(n, from, to, aux, moves);
        return moves;
    }
    
    /**
     * Helper method to recursively solve the Towers of Hanoi puzzle.
     * 
     * @param n number of disks
     * @param from source peg
     * @param to destination peg
     * @param aux auxiliary peg
     * @param moves list to store moves
     */
    private void hanoiHelper(Integer n, String from, String to, String aux, List<Move> moves) {
        if (n == 1) {
            // Base case: move the top disk from source to destination
            moves.add(new Move(from, to));
        } else {
            // Move n-1 disks from source to auxiliary using destination as temporary
            hanoiHelper(n - 1, from, aux, to, moves);
            
            // Move the largest disk from source to destination
            moves.add(new Move(from, to));
            
            // Move n-1 disks from auxiliary to destination using source as temporary
            hanoiHelper(n - 1, aux, to, from, moves);
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