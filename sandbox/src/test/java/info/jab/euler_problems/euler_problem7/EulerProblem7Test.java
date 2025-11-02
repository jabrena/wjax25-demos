package info.jab.euler_problems.euler_problem7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Project Euler Problem 7.
 * 
 * Problem statement: By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
 * we can see that the 6th prime is 13.
 * 
 * What is the 10,001st prime number?
 */
@DisplayName("Euler Problem 7 Tests")
class EulerProblem7Test {

    private final EulerProblem7 solution = new EulerProblem7();

    @Test
    @DisplayName("Should find the 6th prime number correctly")
    void shouldFindSixthPrime() {
        // Given
        int position = 6;

        // When
        long result = solution.findNthPrime(position);

        // Then
        assertThat(result).isEqualTo(13L);
    }

    @Test
    @DisplayName("Should find the 1st prime number correctly")
    void shouldFindFirstPrime() {
        // Given
        int position = 1;

        // When
        long result = solution.findNthPrime(position);

        // Then
        assertThat(result).isEqualTo(2L);
    }

    @Test
    @DisplayName("Should find the 10,001st prime number")
    void shouldFind10001stPrime() {
        // Given
        int position = 10001;

        // When
        long result = solution.findNthPrime(position);

        // Then
        assertThat(result).isPositive();
        assertThat(result).isGreaterThan(2L);
    }
}
