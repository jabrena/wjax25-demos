package info.jab.eulerproblems.eulerproblem3;

/**
 * Euler Problem 3: Largest Prime Factor
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143?
 * 
 * Solution approach:
 * - Start from 2 and iterate through potential factors
 * - Divide the number by each factor until it's no longer divisible
 * - Continue until the number becomes 1 or a prime
 * - The last factor found will be the largest prime factor
 */
public class EulerProblem3 {

    /**
     * Finds the largest prime factor of a given number.
     * 
     * @param number the number to find the largest prime factor of
     * @return the largest prime factor
     */
    public long largestPrimeFactor(long number) {
        if (number <= 1) {
            throw new IllegalArgumentException("Number must be greater than 1");
        }

        long largestFactor = 1;
        long currentNumber = number;

        // Handle the case when number is even
        while (currentNumber % 2 == 0) {
            largestFactor = 2;
            currentNumber /= 2;
        }

        // Check odd factors starting from 3
        // We only need to check up to sqrt(currentNumber)
        for (long i = 3; i * i <= currentNumber; i += 2) {
            while (currentNumber % i == 0) {
                largestFactor = i;
                currentNumber /= i;
            }
        }

        // If currentNumber is still greater than 1, it's a prime factor
        if (currentNumber > 1) {
            largestFactor = currentNumber;
        }

        return largestFactor;
    }
}
