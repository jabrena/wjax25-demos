package info.jab.eulerproblems.eulerproblem2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 2.
 * Problem: Find the sum of even-valued terms in the Fibonacci sequence
 * (starting with 1, 2) whose values do not exceed four million.
 */
@DisplayName("Euler Problem 2 Tests")
class EulerProblem2Test {

    private final EulerProblem2 solution = new EulerProblem2();

    @Test
    @DisplayName("Should calculate sum of even-valued Fibonacci terms not exceeding four million")
    void shouldCalculateSumOfEvenValuedFibonacciTerms() {
        // Given
        long limit = 4_000_000L;

        // When
        long result = solution.solve(limit);

        // Then
        assertThat(result).isEqualTo(4613732L);
    }

    @Test
    @DisplayName("Should calculate sum for small limit (first few even terms)")
    void shouldCalculateSumForSmallLimit() {
        // Given - limit 89 (first even terms: 2, 8, 34)
        long limit = 89L;

        // When
        long result = solution.solve(limit);

        // Then - 2 + 8 + 34 = 44
        assertThat(result).isEqualTo(44L);
    }

    @Test
    @DisplayName("Should return 0 for limit less than 2")
    void shouldReturnZeroForLimitLessThan2() {
        // Given
        long limit = 1L;

        // When
        long result = solution.solve(limit);

        // Then
        assertThat(result).isEqualTo(0L);
    }

    @Test
    @DisplayName("Should return 2 for limit 2")
    void shouldReturnTwoForLimitTwo() {
        // Given
        long limit = 2L;

        // When
        long result = solution.solve(limit);

        // Then
        assertThat(result).isEqualTo(2L);
    }
}