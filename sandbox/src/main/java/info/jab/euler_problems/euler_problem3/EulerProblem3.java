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
 * For each factor that divides the number, we divide the number by it
 * and continue. The last factor found is the largest prime factor.
 */
public class EulerProblem3 {

    /**
     * Finds the largest prime factor of a given number.
     * 
     * @param number the number to find the largest prime factor of
     * @return the largest prime factor
     * @throws IllegalArgumentException if the number is less than 2
     */
    public long largestPrimeFactor(long number) {
        if (number < 2) {
            throw new IllegalArgumentException("Number must be at least 2");
        }

        long largestFactor = 1;
        long currentNumber = number;

        // Handle the case when the number is even
        while (currentNumber % 2 == 0) {
            largestFactor = 2;
            currentNumber /= 2;
        }

        // Check for odd factors starting from 3
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
