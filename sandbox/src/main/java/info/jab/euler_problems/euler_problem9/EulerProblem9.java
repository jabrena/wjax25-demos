package info.jab.euler_problems.euler_problem9;

public class EulerProblem9 {

    /**
     * Finds the product of the Pythagorean triplet where a + b + c = sum.
     * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which a? + b? = c?.
     *
     * @param sum the sum of a + b + c
     * @return the product abc
     * @throws IllegalArgumentException if no Pythagorean triplet exists for the given sum
     */
    public static long findPythagoreanTripletProduct(int sum) {
        // Iterate through possible values of a
        // Since a < b < c and a + b + c = sum, we know a < sum/3
        for (int a = 1; a < sum / 3; a++) {
            // For each a, iterate through possible values of b
            // Since a < b < c and a + b + c = sum, we need to ensure c > b
            for (int b = a + 1; b < sum - a; b++) {
                // Calculate c from the constraint a + b + c = sum
                int c = sum - a - b;
                
                // Ensure c > b (since we need a < b < c)
                if (c <= b) {
                    break; // No need to continue if c is not greater than b
                }
                
                // Check if this is a Pythagorean triplet: a? + b? = c?
                if (a * a + b * b == c * c) {
                    return (long) a * b * c;
                }
            }
        }
        
        throw new IllegalArgumentException("No Pythagorean triplet found for sum: " + sum);
    }
}
