package info.jab.euler_problems.euler_problem3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 3: Largest Prime Factor
 * 
 * Problem statement:
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143?
 */
@DisplayName("Euler Problem 3 Tests")
class EulerProblem3Test {

    private EulerProblem3 solution = new EulerProblem3();

    @Test
    @DisplayName("Should find the largest prime factor of 13195")
    void shouldFindLargestPrimeFactorOf13195() {
        // Given
        long number = 13195L;

        // When
        long result = solution.largestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(29L);
    }

    @Test
    @DisplayName("Should find the largest prime factor of 600851475143")
    void shouldFindLargestPrimeFactorOf600851475143() {
        // Given
        long number = 600851475143L;

        // When
        long result = solution.largestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(6857L);
    }

    @Test
    @DisplayName("Should handle small prime numbers")
    void shouldHandleSmallPrimeNumbers() {
        // Given
        long number = 7L;

        // When
        long result = solution.largestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(7L);
    }

    @Test
    @DisplayName("Should handle composite numbers")
    void shouldHandleCompositeNumbers() {
        // Given
        long number = 10L;

        // When
        long result = solution.largestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(5L);
    }
}
