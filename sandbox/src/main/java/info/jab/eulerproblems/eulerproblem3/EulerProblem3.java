package info.jab.eulerproblems.eulerproblem3;

/**
 * Solution for Euler Problem 3: Largest Prime Factor
 * 
 * Problem statement:
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143?
 * 
 * Algorithm:
 * To find the largest prime factor, we:
 * 1. Start dividing the number by 2 (smallest prime)
 * 2. Continue dividing by increasing factors
 * 3. When a factor is found, divide the number by it completely
 * 4. The last factor that divides the number is the largest prime factor
 */
public class EulerProblem3 {

    /**
     * Finds the largest prime factor of a given number.
     * 
     * @param number the number to find the largest prime factor of
     * @return the largest prime factor
     */
    public long findLargestPrimeFactor(long number) {
        if (number <= 1) {
            throw new IllegalArgumentException("Number must be greater than 1");
        }

        long largestFactor = 1;
        long n = number;

        // Handle even factors
        while (n % 2 == 0) {
            largestFactor = 2;
            n /= 2;
        }

        // Handle odd factors starting from 3
        // Only check up to sqrt(n) since any factor larger than sqrt(n) 
        // would have a corresponding factor smaller than sqrt(n)
        for (long i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                largestFactor = i;
                n /= i;
            }
        }

        // If n is still greater than 1, it's a prime factor itself
        if (n > 1) {
            largestFactor = n;
        }

        return largestFactor;
    }
}