package info.jab.euler_problems.euler_problem3;

/**
 * Solution for Project Euler problem 3:
 * <p>
 * Find the largest prime factor of the composite number 600851475143.
 * </p>
 */
public class EulerProblem3 {

    /**
     * Computes the largest prime factor of the provided positive integer.
     *
     * @param value a number greater than 1
     * @return the largest prime factor
     * @throws IllegalArgumentException if {@code value < 2}
     */
    public long largestPrimeFactor(long value) {
        if (value < 2) {
            throw new IllegalArgumentException("Value must be >= 2");
        }

        long candidate = value;
        long largestFactor = 1L;

        // Remove factor 2 to simplify iteration.
        while ((candidate & 1L) == 0L) {
            largestFactor = 2L;
            candidate >>= 1;
        }

        long factor = 3L;
        while (factor * factor <= candidate) {
            if (candidate % factor == 0L) {
                largestFactor = factor;
                candidate /= factor;
            } else {
                factor += 2;
            }
        }

        if (candidate > 1L) {
            largestFactor = candidate;
        }

        return largestFactor;
    }
}
