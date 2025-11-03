package info.jab.euler_problems.euler_problem3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 3.
 * 
 * Problem: The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143?
 */
@DisplayName("Euler Problem 3 Tests")
class EulerProblem3Test {

    @Test
    @DisplayName("Should find the largest prime factor of 13195")
    void shouldFindLargestPrimeFactorOf13195() {
        // Given
        long number = 13195L;
        EulerProblem3 solver = new EulerProblem3();

        // When
        long result = solver.findLargestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(29L);
    }

    @Test
    @DisplayName("Should find the largest prime factor of 600851475143")
    void shouldFindLargestPrimeFactorOf600851475143() {
        // Given
        long number = 600851475143L;
        EulerProblem3 solver = new EulerProblem3();

        // When
        long result = solver.findLargestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(6857L);
    }

    @Test
    @DisplayName("Should handle prime numbers")
    void shouldHandlePrimeNumbers() {
        // Given
        long primeNumber = 17L;
        EulerProblem3 solver = new EulerProblem3();

        // When
        long result = solver.findLargestPrimeFactor(primeNumber);

        // Then
        assertThat(result).isEqualTo(17L);
    }

    @Test
    @DisplayName("Should handle number 2")
    void shouldHandleNumber2() {
        // Given
        long number = 2L;
        EulerProblem3 solver = new EulerProblem3();

        // When
        long result = solver.findLargestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(2L);
    }
}