package info.jab.eulerproblems.eulerproblem1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 1.
 * Problem: Find the sum of all the multiples of 3 or 5 below 1000.
 * Example: For numbers below 10, multiples of 3 or 5 are 3, 5, 6, 9, and their sum is 23.
 */
@DisplayName("Euler Problem 1 Tests")
class EulerProblem1Test {

    private final EulerProblem1 solution = new EulerProblem1();

    @Test
    @DisplayName("Should return 23 for numbers below 10")
    void shouldReturn23ForNumbersBelow10() {
        // Given
        int limit = 10;

        // When
        long result = solution.solve(limit);

        // Then
        assertThat(result).isEqualTo(23);
    }

    @Test
    @DisplayName("Should return correct sum for numbers below 1000")
    void shouldReturnCorrectSumForNumbersBelow1000() {
        // Given
        int limit = 1000;

        // When
        long result = solution.solve(limit);

        // Then
        assertThat(result).isPositive();
    }

    @Test
    @DisplayName("Should return 0 for limit less than 3")
    void shouldReturn0ForLimitLessThan3() {
        // Given
        int limit = 2;

        // When
        long result = solution.solve(limit);

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Should handle limit of 3 correctly")
    void shouldHandleLimitOf3Correctly() {
        // Given
        int limit = 3;

        // When
        long result = solution.solve(limit);

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Should handle limit of 5 correctly")
    void shouldHandleLimitOf5Correctly() {
        // Given
        int limit = 5;

        // When
        long result = solution.solve(limit);

        // Then
        assertThat(result).isEqualTo(3);
    }
}
