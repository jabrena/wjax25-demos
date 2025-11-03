package info.jab.euler_problems.euler_problem3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for Euler Problem 3: Largest Prime Factor
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143?
 */
@DisplayName("Euler Problem 3 Tests")
class EulerProblem3Test {

    @Test
    @DisplayName("Should find the largest prime factor of 13195")
    void shouldFindLargestPrimeFactorOf13195() {
        // Given
        long number = 13195L;
        EulerProblem3 solution = new EulerProblem3();

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
        EulerProblem3 solution = new EulerProblem3();

        // When
        long result = solution.largestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(6857L);
    }

    @Test
    @DisplayName("Should handle prime numbers correctly")
    void shouldHandlePrimeNumbers() {
        // Given
        EulerProblem3 solution = new EulerProblem3();

        // When & Then
        assertThat(solution.largestPrimeFactor(2L)).isEqualTo(2L);
        assertThat(solution.largestPrimeFactor(3L)).isEqualTo(3L);
        assertThat(solution.largestPrimeFactor(17L)).isEqualTo(17L);
    }

    @Test
    @DisplayName("Should handle composite numbers correctly")
    void shouldHandleCompositeNumbers() {
        // Given
        EulerProblem3 solution = new EulerProblem3();

        // When & Then
        assertThat(solution.largestPrimeFactor(10L)).isEqualTo(5L);
        assertThat(solution.largestPrimeFactor(15L)).isEqualTo(5L);
        assertThat(solution.largestPrimeFactor(100L)).isEqualTo(5L);
    }
}
