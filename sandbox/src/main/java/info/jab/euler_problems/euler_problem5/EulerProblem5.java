package info.jab.euler_problems.euler_problem5;

/**
 * Solution for Euler Problem 5.
 * 
 * Problem statement:
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * 
 * Solution approach:
 * This problem requires finding the Least Common Multiple (LCM) of all numbers from 1 to n.
 * The LCM of multiple numbers can be found by repeatedly applying LCM to pairs of numbers.
 * LCM(a, b) = (a * b) / GCD(a, b)
 */
public class EulerProblem5 {

    /**
     * Finds the smallest positive number that is evenly divisible by all numbers from 1 to upperLimit.
     * 
     * @param upperLimit the upper limit of the range (inclusive)
     * @return the smallest positive number divisible by all numbers from 1 to upperLimit
     */
    public long solve(int upperLimit) {
        if (upperLimit < 1) {
            throw new IllegalArgumentException("Upper limit must be at least 1");
        }

        long result = 1;
        // Calculate LCM of all numbers from 1 to upperLimit
        for (int i = 1; i <= upperLimit; i++) {
            result = lcm(result, i);
        }
        return result;
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
