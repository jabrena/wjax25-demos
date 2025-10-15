package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.List;

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
     * @param n Number of disks
     * @param from Source peg
     * @param to Destination peg
     * @param temp Temporary peg
     * @return List of moves to solve the puzzle
     */
    public List<Move> hanoi(Integer n, String from, String to, String temp) {
        List<Move> moves = new ArrayList<>();
        
        if (n <= 0) {
            return moves;
        }
        
        // Move n-1 disks from source to temporary using destination as temp
        moves.addAll(hanoi(n - 1, from, temp, to));
        
        // Move the largest disk from source to destination
        moves.add(new Move(from, to));
        
        // Move n-1 disks from temporary to destination using source as temp
        moves.addAll(hanoi(n - 1, temp, to, from));
        
        return moves;
    }
}