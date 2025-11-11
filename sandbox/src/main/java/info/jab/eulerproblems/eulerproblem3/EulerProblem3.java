package info.jab.eulerproblems.eulerproblem3;

/**
 * Euler Problem 3: Largest Prime Factor
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143?
 * 
 * Solution approach:
 * We iterate through potential factors starting from 2.
 * For each factor that divides the number, we divide it out completely.
 * The last remaining factor (or the number itself if it's prime) will be the largest prime factor.
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

        long largestPrimeFactor = 1;
        long currentNumber = number;
        long factor = 2;

        // Handle the case when the number is even
        while (currentNumber % 2 == 0) {
            largestPrimeFactor = 2;
            currentNumber /= 2;
        }

        // Check odd factors starting from 3
        // We only need to check up to sqrt(currentNumber) because
        // any factor larger than sqrt(n) would have a corresponding factor smaller than sqrt(n)
        factor = 3;
        while (factor * factor <= currentNumber) {
            while (currentNumber % factor == 0) {
                largestPrimeFactor = factor;
                currentNumber /= factor;
            }
            factor += 2; // Only check odd numbers
        }

        // If currentNumber is still greater than 1, it's a prime factor itself
        if (currentNumber > 1) {
            largestPrimeFactor = currentNumber;
        }

        return largestPrimeFactor;
    }
}
