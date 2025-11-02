package info.jab.eulerproblems.eulerproblem5;

/**
 * Solution for Euler Problem 5.
 * Problem: What is the smallest positive number that is evenly divisible by all of the numbers from 1 to n?
 * 
 * This is essentially finding the Least Common Multiple (LCM) of all numbers from 1 to n.
 */
public class EulerProblem5 {

    /**
     * Finds the smallest positive number that is evenly divisible by all numbers from 1 to n.
     * 
     * @param n the upper bound (inclusive)
     * @return the smallest number divisible by all numbers from 1 to n
     */
    public long solve(int n) {
        long lcm = 1;
        for (int i = 2; i <= n; i++) {
            lcm = lcm(lcm, i);
        }
        return lcm;
    }

    /**
     * Calculates the Least Common Multiple (LCM) of two numbers.
     * 
     * @param a the first number
     * @param b the second number
     * @return the LCM of a and b
     */
    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    /**
     * Calculates the Greatest Common Divisor (GCD) of two numbers using Euclidean algorithm.
     * 
     * @param a the first number
     * @param b the second number
     * @return the GCD of a and b
     */
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
