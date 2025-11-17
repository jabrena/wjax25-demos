package info.jab.euler-problems.euler-problem3;

import org.junit.jupiter.api.BeforeEach;
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

    private EulerProblem3 solver;

    @BeforeEach
    void setUp() {
        solver = new EulerProblem3();
    }

    @Test
    @DisplayName("Should find largest prime factor of 13195")
    void shouldFindLargestPrimeFactorOf13195() {
        // Given
        long number = 13195L;

        // When
        long result = solver.largestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(29L);
    }

    @Test
    @DisplayName("Should find largest prime factor of 600851475143")
    void shouldFindLargestPrimeFactorOf600851475143() {
        // Given
        long number = 600851475143L;

        // When
        long result = solver.largestPrimeFactor(number);

        // Then
        assertThat(result).isPositive();
        // Verify it's a prime factor by checking divisibility
        assertThat(number % result).isEqualTo(0L);
    }

    @Test
    @DisplayName("Should handle prime numbers correctly")
    void shouldHandlePrimeNumbers() {
        // Given
        long primeNumber = 17L;

        // When
        long result = solver.largestPrimeFactor(primeNumber);

        // Then
        assertThat(result).isEqualTo(17L);
    }

    @Test
    @DisplayName("Should handle small composite numbers")
    void shouldHandleSmallCompositeNumbers() {
        // Given
        long number = 10L; // 2 * 5

        // When
        long result = solver.largestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(5L);
    }
}
