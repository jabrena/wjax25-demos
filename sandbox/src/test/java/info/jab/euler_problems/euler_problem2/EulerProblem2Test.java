package info.jab.euler_problems.euler_problem2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 2.
 * Problem: Find the sum of even-valued terms in the Fibonacci sequence
 * whose values do not exceed four million.
 */
@DisplayName("Euler Problem 2 Tests")
class EulerProblem2Test {

    private EulerProblem2 solution = new EulerProblem2();

    @Test
    @DisplayName("Should return correct sum of even Fibonacci numbers up to 4 million")
    void shouldReturnCorrectSumForFourMillion() {
        // Given
        long maxValue = 4_000_000L;

        // When
        long result = solution.solve(maxValue);

        // Then
        assertThat(result).isEqualTo(4613732L);
    }

    @Test
    @DisplayName("Should return 2 for max value 10")
    void shouldReturnCorrectSumForSmallValue() {
        // Given
        long maxValue = 10L;
        // Fibonacci sequence: 1, 2, 3, 5, 8, 13, ...
        // Even values <= 10: 2, 8
        // Sum: 2 + 8 = 10

        // When
        long result = solution.solve(maxValue);

        // Then
        assertThat(result).isEqualTo(10L);
    }

    @Test
    @DisplayName("Should return 0 for max value less than 2")
    void shouldReturnZeroForVerySmallValue() {
        // Given
        long maxValue = 1L;

        // When
        long result = solution.solve(maxValue);

        // Then
        assertThat(result).isEqualTo(0L);
    }

    @Test
    @DisplayName("Should return 2 for max value 2")
    void shouldReturnTwoForMaxValueTwo() {
        // Given
        long maxValue = 2L;

        // When
        long result = solution.solve(maxValue);

        // Then
        assertThat(result).isEqualTo(2L);
    }
}
