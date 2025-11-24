package info.jab.euler_problems.euler_problem3;

/**
 * Solution for Project Euler Problem 3.
 *
 * <p>The problem statement asks for the largest prime factor of 600851475143.</p>
 */
public class EulerProblem3 {

    /**
     * Calculates the largest prime factor of a given positive number.
     *
     * @param number the value whose largest prime factor we want to find
     * @return the largest prime factor
     * @throws IllegalArgumentException if the number is less than 2
     */
    public long largestPrimeFactor(long number) {
        if (number < 2) {
            throw new IllegalArgumentException("Number must be greater than or equal to 2");
        }

        long n = number;
        long largestFactor = 1;

        // remove factors of 2
        while ((n & 1) == 0 && n > 1) {
            largestFactor = 2;
            n /= 2;
        }

        // check odd factors
        long factor = 3;
        long maxFactor = (long) Math.sqrt(n);
        while (n > 1 && factor <= maxFactor) {
            while (n % factor == 0) {
                largestFactor = factor;
                n /= factor;
                maxFactor = (long) Math.sqrt(n);
            }
            factor += 2;
        }

        if (n == 1) {
            return largestFactor;
        }

        return n;
    }

    /**
     * Helper method returning the answer for the canonical problem input.
     *
     * @return the largest prime factor of 600851475143
     */
    public long solve() {
        return largestPrimeFactor(600_851_475_143L);
    }
}
