package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.List;

public class Exercise6 {

    /**
     * Solve the 4-peg Towers of Hanoi puzzle.
     * Uses the Frame-Stewart algorithm for optimal solution.
     * Returns a list of moves to transfer n discs from the first peg to the last peg.
     */
    public static List<Exercise5.Move> hanoi4(int n, String from, String to, String temp1, String temp2) {
        List<Exercise5.Move> moves = new ArrayList<>();
        
        if (n <= 0) {
            return moves;
        }
        
        if (n == 1) {
            moves.add(new Exercise5.Move(from, to));
            return moves;
        }
        
        if (n == 2) {
            // For 2 discs, use temp1 as intermediate
            moves.add(new Exercise5.Move(from, temp1));
            moves.add(new Exercise5.Move(from, to));
            moves.add(new Exercise5.Move(temp1, to));
            return moves;
        }
        
        // For more than 2 discs, use Frame-Stewart algorithm
        // Move k discs to temp1 using temp2 as auxiliary
        int k = (int) Math.round(n - Math.sqrt(2 * n + 1)) + 1;
        
        // Move k discs from 'from' to 'temp1' using 'to' and 'temp2' as auxiliary
        moves.addAll(hanoi4(k, from, temp1, to, temp2));
        
        // Move the remaining n-k discs from 'from' to 'to' using 'temp2' as auxiliary
        // (This is essentially a 3-peg problem)
        moves.addAll(hanoi3(n - k, from, to, temp2));
        
        // Move k discs from 'temp1' to 'to' using 'from' and 'temp2' as auxiliary
        moves.addAll(hanoi4(k, temp1, to, from, temp2));
        
        return moves;
    }
    
    /**
     * Helper method for 3-peg Towers of Hanoi (used in the 4-peg solution).
     */
    private static List<Exercise5.Move> hanoi3(int n, String from, String to, String temp) {
        List<Exercise5.Move> moves = new ArrayList<>();
        
        if (n <= 0) {
            return moves;
        }
        
        if (n == 1) {
            moves.add(new Exercise5.Move(from, to));
            return moves;
        }
        
        // Move n-1 discs from 'from' to 'temp'
        moves.addAll(hanoi3(n - 1, from, temp, to));
        
        // Move the largest disc from 'from' to 'to'
        moves.add(new Exercise5.Move(from, to));
        
        // Move n-1 discs from 'temp' to 'to'
        moves.addAll(hanoi3(n - 1, temp, to, from));
        
        return moves;
    }
}