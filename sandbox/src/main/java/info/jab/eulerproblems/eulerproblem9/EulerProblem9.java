package info.jab.eulerproblems.eulerproblem9;

/**
 * Solution for Euler Problem 9.
 * 
 * Problem: A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a? + b? = c?
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * 
 * Solution approach:
 * - We need to find natural numbers a, b, c such that:
 *   1. a < b < c
 *   2. a? + b? = c? (Pythagorean theorem)
 *   3. a + b + c = 1000
 * 
 * - From condition 3, we have c = 1000 - a - b
 * - Substituting into condition 2: a? + b? = (1000 - a - b)?
 * - Expanding: a? + b? = 1000000 - 2000a - 2000b + 2ab + a? + b?
 * - Simplifying: 0 = 1000000 - 2000a - 2000b + 2ab
 * - Rearranging: 2000a + 2000b - 2ab = 1000000
 * - Dividing by 2: 1000a + 1000b - ab = 500000
 * 
 * - Alternatively, we can iterate over a and b, compute c, and check if:
 *   a? + b? = c? and a + b + c = 1000
 * 
 * - Since a < b < c and a + b + c = 1000, we know:
 *   a < 1000/3 ? 333
 *   b > a and b < (1000 - a) / 2
 */
public class EulerProblem9 {

    /**
     * Finds the Pythagorean triplet with sum 1000 and returns the product abc.
     * 
     * @return the product of the triplet (a * b * c)
     */
    public long solve() {
        final int targetSum = 1000;

        // Iterate through possible values of a
        // Since a < b < c and a + b + c = 1000, a must be less than 333
        for (int a = 1; a < targetSum / 3; a++) {
            // For each a, iterate through possible values of b
            // b must be greater than a and less than (targetSum - a) / 2
            for (int b = a + 1; b < (targetSum - a) / 2; b++) {
                int c = targetSum - a - b;

                // Check if this is a Pythagorean triplet: a? + b? = c?
                if (a * a + b * b == c * c) {
                    // Found the triplet, return the product
                    return (long) a * b * c;
                }
            }
        }

        // This should never happen given the problem statement
        throw new IllegalStateException("No Pythagorean triplet found with sum " + targetSum);
    }
}
