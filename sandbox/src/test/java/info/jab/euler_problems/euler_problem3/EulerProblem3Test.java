package info.jab.euler_problems.euler_problem3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Euler Problem 3: Largest Prime Factor
 *
 * <p>Problem statement:
 * What is the largest prime factor of the number 600851475143?</p>
 */
@DisplayName("Euler Problem 3 Tests")
class EulerProblem3Test {

    private final EulerProblem3 solution = new EulerProblem3();

    @Test
    @DisplayName("Should find the largest prime factor of 600851475143")
    void shouldFindLargestPrimeFactorOfTargetNumber() {
        // Given
        long number = 600851475143L;

        // When
        long result = solution.largestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(6857L);
    }

    @Test
    @DisplayName("Should find largest prime factor of 13195")
    void shouldFindLargestPrimeFactorOf13195() {
        // Given
        long number = 13195L;

        // When
        long result = solution.largestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(29L);
    }

    @Test
    @DisplayName("Should find largest prime factor of 10")
    void shouldFindLargestPrimeFactorOf10() {
        // Given
        long number = 10L;

        // When
        long result = solution.largestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(5L);
    }

    @Test
    @DisplayName("Should return the number itself if it is prime")
    void shouldReturnNumberItselfIfPrime() {
        // Given
        long number = 17L; // prime number

        // When
        long result = solution.largestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(17L);
    }
}
