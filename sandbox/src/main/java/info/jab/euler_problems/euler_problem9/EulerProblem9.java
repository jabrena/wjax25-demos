package info.jab.euler_problems.euler_problem9;

/**
 * Solution for Euler Problem 9: Special Pythagorean triplet
 * 
 * Problem: A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a? + b? = c?
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class EulerProblem9 {

    /**
     * Finds the product of the Pythagorean triplet with the given sum.
     * 
     * A Pythagorean triplet satisfies:
     * - a < b < c
     * - a? + b? = c?
     * - a + b + c = targetSum
     * 
     * @param targetSum the sum of the three numbers (a + b + c)
     * @return the product abc, or 0 if no such triplet exists
     */
    public long solve(int targetSum) {
        // Since a < b < c and a + b + c = targetSum,
        // we know that a < targetSum/3, b < targetSum/2
        
        // Iterate through possible values of a and b
        for (int a = 1; a < targetSum / 3; a++) {
            for (int b = a + 1; b < targetSum / 2; b++) {
                // Calculate c from the constraint: a + b + c = targetSum
                int c = targetSum - a - b;
                
                // Ensure c > b (to maintain a < b < c)
                if (c <= b) {
                    continue;
                }
                
                // Check if this is a Pythagorean triplet: a? + b? = c?
                if (isPythagoreanTriplet(a, b, c)) {
                    return (long) a * b * c;
                }
            }
        }
        
        // No triplet found
        return 0;
    }
    
    /**
     * Checks if the three numbers form a Pythagorean triplet.
     * 
     * @param a first number
     * @param b second number
     * @param c third number
     * @return true if a? + b? = c?, false otherwise
     */
    private boolean isPythagoreanTriplet(int a, int b, int c) {
        return (a * a + b * b) == (c * c);
    }
}
