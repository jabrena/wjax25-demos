package info.jab.euler_problems.euler_problem3;

/**
 * Solution for Euler Problem 3.
 * 
 * Problem: The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143?
 * 
 * This class provides a method to find the largest prime factor of a given number.
 */
public class EulerProblem3 {

    /**
     * Finds the largest prime factor of a given number.
     * 
     * The algorithm works by:
     * 1. Starting from 2, iteratively dividing the number by its factors
     * 2. When a factor is found, the number is divided by that factor
     * 3. Continuing until the number becomes 1
     * 4. The last factor found is the largest prime factor
     * 
     * @param number the number to find the largest prime factor of
     * @return the largest prime factor
     * @throws IllegalArgumentException if number is less than 2
     */
    public long findLargestPrimeFactor(long number) {
        if (number < 2) {
            throw new IllegalArgumentException("Number must be at least 2");
        }

        long largestPrimeFactor = 2;
        long currentNumber = number;

        // Handle the case when the number is even
        while (currentNumber % 2 == 0) {
            currentNumber /= 2;
            if (currentNumber == 1) {
                return 2;
            }
        }

        // Check odd factors starting from 3
        for (long factor = 3; factor * factor <= currentNumber; factor += 2) {
            while (currentNumber % factor == 0) {
                largestPrimeFactor = factor;
                currentNumber /= factor;
            }
        }

        // If currentNumber is still greater than 2, it is itself a prime factor
        if (currentNumber > 2) {
            largestPrimeFactor = currentNumber;
        }

        return largestPrimeFactor;
    }
}