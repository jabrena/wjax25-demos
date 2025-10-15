package info.jab.cis194.homework1;

/**
 * Exercise 2 - Tower of Hanoi
 * Based on CIS 1940 Homework 1 - Recursive Functions
 * 
 * This exercise implements the Tower of Hanoi puzzle solution
 * using recursive approach, adapted from Haskell to Java.
 */
public class Exercise2 {

    /**
     * Solves the Tower of Hanoi puzzle for n disks.
     * 
     * @param n number of disks
     * @param from source peg
     * @param via auxiliary peg
     * @param to destination peg
     * @return string representation of the moves
     */
    public static String hanoi(int n, char from, char via, char to) {
        if (n <= 0) {
            return "";
        }
        
        StringBuilder moves = new StringBuilder();
        
        // Move n-1 disks from source to auxiliary
        String move1 = hanoi(n - 1, from, to, via);
        if (!move1.isEmpty()) {
            moves.append(move1).append("\n");
        }
        
        // Move the largest disk from source to destination
        moves.append("Move disk from ").append(from).append(" to ").append(to);
        
        // Move n-1 disks from auxiliary to destination
        String move2 = hanoi(n - 1, via, from, to);
        if (!move2.isEmpty()) {
            moves.append("\n").append(move2);
        }
        
        return moves.toString();
    }
}