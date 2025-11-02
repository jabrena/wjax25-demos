package info.jab.euler_problems.euler_problem3;

/**
 * Solution to Euler Problem 3: Largest Prime Factor
 * 
 * Problem: The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143?
 * 
 * Algorithm:
 * - Start from the smallest prime (2) and divide the number by it as long as possible
 * - Move to the next odd number and repeat
 * - Continue until the number is reduced to 1 or we've checked all factors up to sqrt(n)
 * - If the remaining number is greater than 1, it's a prime and is the largest factor
 */
public class EulerProblem3 {

    /**
     * Finds the largest prime factor of a given number.
     * 
     * @param number the number to find the largest prime factor of
     * @return the largest prime factor of the number
     * @throws IllegalArgumentException if the number is less than 2
     */
    public long largestPrimeFactor(long number) {
        if (number < 2) {
            throw new IllegalArgumentException("Number must be at least 2");
        }

        long largestFactor = 1;
        long currentNumber = number;

        // Handle factor 2 separately (only even prime)
        while (currentNumber % 2 == 0) {
            largestFactor = 2;
            currentNumber /= 2;
        }

        // Check odd factors starting from 3
        // Only need to check up to sqrt(currentNumber)
        for (long factor = 3; factor * factor <= currentNumber; factor += 2) {
            while (currentNumber % factor == 0) {
                largestFactor = factor;
                currentNumber /= factor;
            }
        }

        // If currentNumber is still greater than 1, it's a prime factor
        if (currentNumber > 1) {
            largestFactor = currentNumber;
        }

        return largestFactor;
    }
}
