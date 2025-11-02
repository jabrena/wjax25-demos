package info.jab.euler_problems.euler_problem9;

/**
 * Solution for Euler Problem 9.
 * 
 * Problem: A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a? + b? = c?
 * 
 * For example, 3? + 4? = 9 + 16 = 25 = 5?.
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class EulerProblem9 {

    /**
     * Solves Euler Problem 9 by finding the Pythagorean triplet with sum 1000.
     * 
     * @return the product of the three numbers in the Pythagorean triplet
     */
    public long solve() {
        // Iterate through possible values of a and b
        // Since a < b < c and a + b + c = 1000, we can optimize the search space
        
        for (int a = 1; a < 333; a++) { // a < 1000/3 since a < b < c
            for (int b = a + 1; b < 500; b++) { // b < 500 since b < c
                int c = 1000 - a - b;
                
                // Check if c is valid (positive and greater than b)
                if (c > b) {
                    // Check if it's a Pythagorean triplet: a? + b? = c?
                    if (a * a + b * b == c * c) {
                        return (long) a * b * c;
                    }
                }
            }
        }
        
        // Should never reach here according to the problem statement
        throw new IllegalStateException("No Pythagorean triplet found with sum 1000");
    }
}
