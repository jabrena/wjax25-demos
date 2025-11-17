package info.jab.euler_problems.euler_problem3;

/**
 * Solution for Euler Problem 3: Largest Prime Factor
 * 
 * Problem statement:
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143?
 * 
 * Algorithm:
 * We iterate through potential factors starting from 2.
 * For each factor found, we divide the number by it repeatedly until it's no longer divisible.
 * The last factor found will be the largest prime factor.
 */
public class EulerProblem3 {

    /**
     * Finds the largest prime factor of the given number.
     * 
     * @param number the number to find the largest prime factor for
     * @return the largest prime factor
     */
    public long largestPrimeFactor(long number) {
        if (number <= 1) {
            throw new IllegalArgumentException("Number must be greater than 1");
        }

        long largestFactor = 1;
        long currentNumber = number;

        // Handle factor 2 separately (only even prime)
        while (currentNumber % 2 == 0) {
            largestFactor = 2;
            currentNumber /= 2;
        }

        // Check odd factors starting from 3
        // We only need to check up to sqrt(currentNumber)
        for (long factor = 3; factor * factor <= currentNumber; factor += 2) {
            while (currentNumber % factor == 0) {
                largestFactor = factor;
                currentNumber /= factor;
            }
        }

        // If currentNumber is still greater than 1, it's a prime factor itself
        if (currentNumber > 1) {
            largestFactor = currentNumber;
        }

        return largestFactor;
    }
}
