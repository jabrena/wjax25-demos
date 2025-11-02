package info.jab.euler_problems.euler_problem5;

/**
 * Euler Problem 5: Smallest Multiple
 * 
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * 
 * Solution: This is equivalent to finding the Least Common Multiple (LCM) of all numbers from 1 to n.
 * 
 * Approach: LCM can be calculated iteratively:
 * LCM(a, b, c, ...) = LCM(LCM(a, b), c, ...)
 * Where LCM(a, b) = (a * b) / GCD(a, b)
 */
public class EulerProblem5 {

    /**
     * Finds the smallest positive number that is evenly divisible by all numbers from 1 to upperBound.
     * 
     * @param upperBound the upper bound (inclusive)
     * @return the smallest positive number divisible by all numbers from 1 to upperBound
     */
    public long solve(int upperBound) {
        if (upperBound < 1) {
            throw new IllegalArgumentException("Upper bound must be at least 1");
        }
        
        if (upperBound == 1) {
            return 1L;
        }
        
        // Start with the LCM of 1 and 2
        long lcm = 2L;
        
        // Iteratively compute LCM with each subsequent number
        for (int i = 3; i <= upperBound; i++) {
            lcm = lcm(lcm, i);
        }
        
        return lcm;
    }
    
    /**
     * Calculates the Least Common Multiple (LCM) of two numbers.
     * 
     * @param a first number
     * @param b second number
     * @return LCM of a and b
     */
    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
    
    /**
     * Calculates the Greatest Common Divisor (GCD) of two numbers using Euclid's algorithm.
     * 
     * @param a first number
     * @param b second number
     * @return GCD of a and b
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
