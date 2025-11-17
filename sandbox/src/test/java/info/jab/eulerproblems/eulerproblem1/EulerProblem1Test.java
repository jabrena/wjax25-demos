package info.jab.eulerproblems.eulerproblem1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 1.
 * Problem: Find the sum of all the multiples of 3 or 5 below 1000.
 */
@DisplayName("Euler Problem 1 Tests")
class EulerProblem1Test {

    private final EulerProblem1 solution = new EulerProblem1();

    @Test
    @DisplayName("Should return 23 for multiples of 3 or 5 below 10")
    void shouldReturn23ForMultiplesBelow10() {
        // Given
        int limit = 10;

        // When
        long result = solution.solve(limit);

        // Then
        assertThat(result).isEqualTo(23);
    }

    @Test
    @DisplayName("Should return the sum of all multiples of 3 or 5 below 1000")
    void shouldReturnSumForMultiplesBelow1000() {
        // Given
        int limit = 1000;

        // When
        long result = solution.solve(limit);

        // Then
        assertThat(result).isEqualTo(233168);
    }

    @Test
    @DisplayName("Should return 0 for limit below 3")
    void shouldReturn0ForLimitBelow3() {
        // Given
        int limit = 2;

        // When
        long result = solution.solve(limit);

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Should handle edge case with limit 3")
    void shouldHandleEdgeCaseWithLimit3() {
        // Given
        int limit = 3;

        // When
        long result = solution.solve(limit);

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Should handle edge case with limit 5")
    void shouldHandleEdgeCaseWithLimit5() {
        // Given
        int limit = 5;

        // When
        long result = solution.solve(limit);

        // Then
        assertThat(result).isEqualTo(3);
    }
}
