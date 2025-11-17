package info.jab.euler-problems.euler-problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 1.
 * Problem: Find the sum of all multiples of 3 or 5 below 1000.
 */
@DisplayName("Euler Problem 1 Tests")
class EulerProblem1Test {

    private EulerProblem1 eulerProblem1;

    @BeforeEach
    void setUp() {
        eulerProblem1 = new EulerProblem1();
    }

    @Test
    @DisplayName("Should return 23 for numbers below 10")
    void shouldReturn23ForNumbersBelow10() {
        // Given
        int limit = 10;

        // When
        long result = eulerProblem1.solve(limit);

        // Then
        assertThat(result).isEqualTo(23);
    }

    @Test
    @DisplayName("Should return the sum of all multiples of 3 or 5 below 1000")
    void shouldReturnSumForNumbersBelow1000() {
        // Given
        int limit = 1000;

        // When
        long result = eulerProblem1.solve(limit);

        // Then
        assertThat(result).isEqualTo(233168);
    }

    @Test
    @DisplayName("Should return 0 for limit below 3")
    void shouldReturn0ForLimitBelow3() {
        // Given
        int limit = 2;

        // When
        long result = eulerProblem1.solve(limit);

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Should handle limit of 3 correctly")
    void shouldHandleLimitOf3Correctly() {
        // Given
        int limit = 3;

        // When
        long result = eulerProblem1.solve(limit);

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Should handle limit of 5 correctly")
    void shouldHandleLimitOf5Correctly() {
        // Given
        int limit = 5;

        // When
        long result = eulerProblem1.solve(limit);

        // Then
        assertThat(result).isEqualTo(3);
    }
}
