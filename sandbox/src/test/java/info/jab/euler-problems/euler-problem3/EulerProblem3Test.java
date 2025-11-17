package info.jab.euler-problems.euler-problem3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 3.
 * Problem: What is the largest prime factor of the number 600851475143?
 */
@DisplayName("Euler Problem 3 Tests")
class EulerProblem3Test {

    private EulerProblem3 solver;

    @BeforeEach
    void setUp() {
        solver = new EulerProblem3();
    }

    @Test
    @DisplayName("Should find the largest prime factor of 600851475143")
    void shouldFindLargestPrimeFactorOf600851475143() {
        // Given
        long number = 600851475143L;

        // When
        long result = solver.largestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(6857L);
    }

    @Test
    @DisplayName("Should find the largest prime factor of 13195")
    void shouldFindLargestPrimeFactorOf13195() {
        // Given
        long number = 13195L;

        // When
        long result = solver.largestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(29L);
    }

    @Test
    @DisplayName("Should find the largest prime factor of a prime number")
    void shouldFindLargestPrimeFactorOfPrimeNumber() {
        // Given
        long number = 17L;

        // When
        long result = solver.largestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(17L);
    }

    @Test
    @DisplayName("Should find the largest prime factor of 2")
    void shouldFindLargestPrimeFactorOf2() {
        // Given
        long number = 2L;

        // When
        long result = solver.largestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(2L);
    }

    @Test
    @DisplayName("Should throw exception for numbers less than 2")
    void shouldThrowExceptionForNumbersLessThan2() {
        // Given
        long number = 1L;

        // When & Then
        assertThatThrownBy(() -> solver.largestPrimeFactor(number))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Number must be at least 2");
    }
}
