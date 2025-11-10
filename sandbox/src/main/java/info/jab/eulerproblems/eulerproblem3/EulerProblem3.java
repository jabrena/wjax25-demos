package info.jab.eulerproblems.eulerproblem3;

/**
 * Solution for Euler Problem 3: Largest Prime Factor
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143?
 * 
 * This class provides a method to find the largest prime factor of a given number.
 */
public class EulerProblem3 {

    /**
     * Finds the largest prime factor of a given number.
     * 
     * The algorithm works by:
     * 1. Starting from 2, check if the number is divisible by the current factor
     * 2. If divisible, divide the number by the factor and continue
     * 3. If not divisible, increment the factor
     * 4. Continue until the number is reduced to 1
     * 5. The last factor that divided the number is the largest prime factor
     * 
     * @param number the number to find the largest prime factor of
     * @return the largest prime factor of the given number
     * @throws IllegalArgumentException if the number is less than 2
     */
    public long largestPrimeFactor(long number) {
        if (number < 2) {
            throw new IllegalArgumentException("Number must be at least 2");
        }

        long largestFactor = 1;
        long currentNumber = number;
        long factor = 2;

        // Handle the case when the number is even
        while (currentNumber % factor == 0) {
            largestFactor = factor;
            currentNumber /= factor;
        }

        // Check odd factors starting from 3
        factor = 3;
        while (factor * factor <= currentNumber) {
            if (currentNumber % factor == 0) {
                largestFactor = factor;
                currentNumber /= factor;
            } else {
                // Skip even numbers
                factor += 2;
            }
        }

        // If currentNumber is greater than 1, it's the largest prime factor
        if (currentNumber > 1) {
            largestFactor = currentNumber;
        }

        return largestFactor;
    }
}
