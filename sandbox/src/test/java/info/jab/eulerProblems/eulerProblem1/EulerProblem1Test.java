package info.jab.eulerProblems.eulerProblem1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 1.
 * 
 * Problem: Find the sum of all multiples of 3 or 5 below a given limit.
 * Example: For numbers below 10, we get 3, 5, 6, 9 which sum to 23.
 */
@DisplayName("Euler Problem 1 Tests")
class EulerProblem1Test {

    private EulerProblem1 solution = new EulerProblem1();

    @Test
    @DisplayName("Should return correct sum for limit 10 (example from problem)")
    void shouldReturnCorrectSumForLimit10() {
        // Given
        int limit = 10;

        // When
        long result = solution.solve(limit);

        // Then
        assertThat(result).isEqualTo(23);
    }

    @Test
    @DisplayName("Should return correct sum for limit 1000 (actual problem)")
    void shouldReturnCorrectSumForLimit1000() {
        // Given
        int limit = 1000;

        // When
        long result = solution.solve(limit);

        // Then
        // The expected value is 233168
        assertThat(result).isEqualTo(233168);
    }

    @ParameterizedTest
    @DisplayName("Should return correct sum for various limits")
    @CsvSource({
        "1, 0",
        "3, 0",
        "4, 3",
        "5, 3",
        "6, 8",
        "10, 23",
        "15, 45",
        "20, 78",
        "100, 2318"
    })
    void shouldReturnCorrectSumForVariousLimits(int limit, long expected) {
        // When
        long result = solution.solve(limit);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should return 0 for limit 0")
    void shouldReturnZeroForLimitZero() {
        // When
        long result = solution.solve(0);

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Should return 0 for negative limit")
    void shouldReturnZeroForNegativeLimit() {
        // When
        long result = solution.solve(-10);

        // Then
        assertThat(result).isEqualTo(0);
    }
}
