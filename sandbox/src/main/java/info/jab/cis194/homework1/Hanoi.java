package info.jab.cis194.homework1;

import java.util.ArrayList;
import java.util.List;

/**
 * Towers of Hanoi implementation for CIS-194 Homework 1.
 * 
 * Represents a move as a pair of pegs (from, to).
 */
public class Hanoi {
    
    /**
     * Represents a move from one peg to another.
     */
    public record Move(String from, String to) {
    }

    /**
     * Exercise 5: Solve the Towers of Hanoi puzzle.
     * 
     * Move n discs from peg 'from' to peg 'to' using peg 'temp' as temporary storage.
     * 
     * Algorithm:
     * 1. Move n-1 discs from 'from' to 'temp' using 'to' as temporary storage
     * 2. Move the top disc from 'from' to 'to'
     * 3. Move n-1 discs from 'temp' to 'to' using 'from' as temporary storage
     * 
     * @param n number of discs
     * @param from source peg name
     * @param to destination peg name
     * @param temp temporary peg name
     * @return list of moves to solve the puzzle
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
        
        // Step 1: Move n-1 discs from 'from' to 'temp' using 'to' as temporary
        moves.addAll(hanoi(n - 1, from, temp, to));
        
        // Step 2: Move the top disc from 'from' to 'to'
        moves.add(new Move(from, to));
        
        // Step 3: Move n-1 discs from 'temp' to 'to' using 'from' as temporary
        moves.addAll(hanoi(n - 1, temp, to, from));
        
        return moves;
    }
}
