package info.jab.euler_problems.euler_problem3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 3: Largest Prime Factor
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143?
 */
@DisplayName("Euler Problem 3 Tests")
class EulerProblem3Test {

    @Test
    @DisplayName("Should find largest prime factor of 13195")
    void shouldFindLargestPrimeFactorOf13195() {
        // Given
        long number = 13195L;
        EulerProblem3 problem = new EulerProblem3();

        // When
        long result = problem.largestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(29L);
    }

    @Test
    @DisplayName("Should find largest prime factor of 600851475143")
    void shouldFindLargestPrimeFactorOf600851475143() {
        // Given
        long number = 600851475143L;
        EulerProblem3 problem = new EulerProblem3();

        // When
        long result = problem.largestPrimeFactor(number);

        // Then
        assertThat(result).isGreaterThan(0L);
        // Verify it's a prime factor
        assertThat(number % result).isEqualTo(0L);
    }

    @Test
    @DisplayName("Should handle prime numbers")
    void shouldHandlePrimeNumbers() {
        // Given
        long primeNumber = 17L;
        EulerProblem3 problem = new EulerProblem3();

        // When
        long result = problem.largestPrimeFactor(primeNumber);

        // Then
        assertThat(result).isEqualTo(primeNumber);
    }

    @Test
    @DisplayName("Should handle small numbers")
    void shouldHandleSmallNumbers() {
        // Given
        long number = 10L;
        EulerProblem3 problem = new EulerProblem3();

        // When
        long result = problem.largestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(5L);
    }
}
