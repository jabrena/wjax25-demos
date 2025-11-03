package info.jab.euler_problems.euler_problem5;

/**
 * Solution for Euler Problem 5.
 * 
 * Problem: What is the smallest positive number that is evenly divisible 
 * by all of the numbers from 1 to 20?
 * 
 * This is essentially finding the Least Common Multiple (LCM) of all numbers from 1 to n.
 */
public class EulerProblem5 {

    /**
     * Finds the smallest positive number that is evenly divisible by all numbers from 1 to n.
     * 
     * @param n the upper bound (inclusive)
     * @return the smallest positive number divisible by all numbers from 1 to n
     */
    public long solve(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be at least 1");
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = lcm(result, i);
        }
        return result;
    }

    /**
     * Calculates the Least Common Multiple (LCM) of two numbers.
     * Uses the formula: LCM(a, b) = |a * b| / GCD(a, b)
     * 
     * @param a first number
     * @param b second number
     * @return the LCM of a and b
     */
    private long lcm(long a, long b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return Math.abs(a * b) / gcd(a, b);
    }

    /**
     * Calculates the Greatest Common Divisor (GCD) of two numbers using Euclidean algorithm.
     * 
     * @param a first number
     * @param b second number
     * @return the GCD of a and b
     */
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
}
