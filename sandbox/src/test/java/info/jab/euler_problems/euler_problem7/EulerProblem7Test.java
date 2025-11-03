package info.jab.euler_problems.euler_problem7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 7.
 * Problem: What is the 10 001st prime number?
 */
@DisplayName("Euler Problem 7 Tests")
class EulerProblem7Test {

    private final EulerProblem7 solution = new EulerProblem7();

    @Test
    @DisplayName("Should find the 1st prime number")
    void shouldFindFirstPrime() {
        // When
        long result = solution.findNthPrime(1);

        // Then
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("Should find the 2nd prime number")
    void shouldFindSecondPrime() {
        // When
        long result = solution.findNthPrime(2);

        // Then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("Should find the 3rd prime number")
    void shouldFindThirdPrime() {
        // When
        long result = solution.findNthPrime(3);

        // Then
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("Should find the 4th prime number")
    void shouldFindFourthPrime() {
        // When
        long result = solution.findNthPrime(4);

        // Then
        assertThat(result).isEqualTo(7);
    }

    @Test
    @DisplayName("Should find the 6th prime number")
    void shouldFindSixthPrime() {
        // When
        long result = solution.findNthPrime(6);

        // Then
        assertThat(result).isEqualTo(13);
    }

    @Test
    @DisplayName("Should find the 10,001st prime number")
    void shouldFind10001stPrime() {
        // When
        long result = solution.findNthPrime(10001);

        // Then
        assertThat(result).isEqualTo(104743);
    }

    @Test
    @DisplayName("Should throw exception for zero or negative n")
    void shouldThrowExceptionForInvalidInput() {
        // When & Then
        assertThatThrownBy(() -> solution.findNthPrime(0))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> solution.findNthPrime(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
