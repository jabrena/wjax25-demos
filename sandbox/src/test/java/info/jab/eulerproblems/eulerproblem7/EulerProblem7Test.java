package info.jab.eulerproblems.eulerproblem7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 7: What is the 10,001st prime number?
 */
@DisplayName("Euler Problem 7 Tests")
class EulerProblem7Test {

    private final EulerProblem7 solver = new EulerProblem7();

    @Test
    @DisplayName("Should find the 1st prime number")
    void shouldFindFirstPrime() {
        // Given
        int position = 1;

        // When
        long result = solver.getNthPrime(position);

        // Then
        assertThat(result).isEqualTo(2L);
    }

    @Test
    @DisplayName("Should find the 2nd prime number")
    void shouldFindSecondPrime() {
        // Given
        int position = 2;

        // When
        long result = solver.getNthPrime(position);

        // Then
        assertThat(result).isEqualTo(3L);
    }

    @Test
    @DisplayName("Should find the 3rd prime number")
    void shouldFindThirdPrime() {
        // Given
        int position = 3;

        // When
        long result = solver.getNthPrime(position);

        // Then
        assertThat(result).isEqualTo(5L);
    }

    @Test
    @DisplayName("Should find the 4th prime number")
    void shouldFindFourthPrime() {
        // Given
        int position = 4;

        // When
        long result = solver.getNthPrime(position);

        // Then
        assertThat(result).isEqualTo(7L);
    }

    @Test
    @DisplayName("Should find the 5th prime number")
    void shouldFindFifthPrime() {
        // Given
        int position = 5;

        // When
        long result = solver.getNthPrime(position);

        // Then
        assertThat(result).isEqualTo(11L);
    }

    @Test
    @DisplayName("Should find the 6th prime number")
    void shouldFindSixthPrime() {
        // Given
        int position = 6;

        // When
        long result = solver.getNthPrime(position);

        // Then
        assertThat(result).isEqualTo(13L);
    }

    @Test
    @DisplayName("Should find the 10,001st prime number")
    void shouldFind10001stPrime() {
        // Given
        int position = 10001;

        // When
        long result = solver.getNthPrime(position);

        // Then
        assertThat(result).isEqualTo(104743L);
    }
}
