package info.jab.euler_problems.euler_problem5;

/**
 * Solution for Euler Problem 5:
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * 
 * This problem is about finding the Least Common Multiple (LCM) of all numbers from 1 to n.
 * The LCM of multiple numbers can be found by iteratively computing the LCM of pairs.
 * LCM(a, b) = (a * b) / GCD(a, b)
 */
public class EulerProblem5 {

    /**
     * Finds the smallest positive number that is evenly divisible by all numbers from start to end (inclusive).
     * 
     * @param start the starting number (inclusive)
     * @param end the ending number (inclusive)
     * @return the smallest positive number divisible by all numbers from start to end
     */
    public long findSmallestDivisible(int start, int end) {
        if (start < 1 || end < start) {
            throw new IllegalArgumentException("Invalid range: start must be >= 1 and end must be >= start");
        }

        long result = start;
        for (int i = start + 1; i <= end; i++) {
            result = lcm(result, i);
        }
        return result;
    }

    /**
     * Calculates the Least Common Multiple (LCM) of two numbers.
     * LCM(a, b) = (a * b) / GCD(a, b)
     * 
     * @param a the first number
     * @param b the second number
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
     * @param a the first number
     * @param b the second number
     * @return the GCD of a and b
     */
    private long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
