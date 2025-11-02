package info.jab.euler_problems.euler_problem3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 3: Largest Prime Factor
 * 
 * Problem: The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143?
 */
@DisplayName("Euler Problem 3 Tests")
class EulerProblem3Test {

    private EulerProblem3 problem = new EulerProblem3();

    @Test
    @DisplayName("Should find largest prime factor of example number 13195")
    void shouldFindLargestPrimeFactorOfExampleNumber() {
        // Given
        long number = 13195L;

        // When
        long result = problem.largestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(29L);
    }

    @Test
    @DisplayName("Should find largest prime factor of the problem number 600851475143")
    void shouldFindLargestPrimeFactorOfProblemNumber() {
        // Given
        long number = 600851475143L;

        // When
        long result = problem.largestPrimeFactor(number);

        // Then
        assertThat(result).isPositive();
        // Verify it's a prime factor by checking divisibility
        assertThat(number % result).isEqualTo(0L);
    }

    @Test
    @DisplayName("Should return the number itself if it is prime")
    void shouldReturnNumberItselfIfPrime() {
        // Given
        long primeNumber = 17L;

        // When
        long result = problem.largestPrimeFactor(primeNumber);

        // Then
        assertThat(result).isEqualTo(primeNumber);
    }

    @Test
    @DisplayName("Should handle prime square numbers correctly")
    void shouldHandlePrimeSquareNumbers() {
        // Given
        long number = 25L; // 5 * 5

        // When
        long result = problem.largestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(5L);
    }

    @Test
    @DisplayName("Should handle composite numbers with multiple prime factors")
    void shouldHandleCompositeNumbersWithMultiplePrimeFactors() {
        // Given
        long number = 30L; // 2 * 3 * 5

        // When
        long result = problem.largestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(5L);
    }
}
