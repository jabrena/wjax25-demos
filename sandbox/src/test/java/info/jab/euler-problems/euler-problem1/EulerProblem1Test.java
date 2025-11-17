package info.jab.euler-problems.euler-problem1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 1.
 * Problem: Find the sum of all the multiples of 3 or 5 below a given number.
 */
@DisplayName("Euler Problem 1 Tests")
class EulerProblem1Test {

    @Test
    @DisplayName("Should return correct sum for example case (below 10)")
    void shouldReturnCorrectSumForExampleCase() {
        // Given
        int limit = 10;

        // When
        long result = EulerProblem1.solve(limit);

        // Then
        assertThat(result).isEqualTo(23); // 3 + 5 + 6 + 9 = 23
    }

    @Test
    @DisplayName("Should return correct sum for the actual problem (below 1000)")
    void shouldReturnCorrectSumForActualProblem() {
        // Given
        int limit = 1000;

        // When
        long result = EulerProblem1.solve(limit);

        // Then
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
        "20, 78"
    })
    void shouldReturnCorrectSumForVariousLimits(int limit, long expected) {
        // When
        long result = EulerProblem1.solve(limit);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should return zero for limit less than 3")
    void shouldReturnZeroForLimitLessThanThree() {
        // Given
        int limit = 2;

        // When
        long result = EulerProblem1.solve(limit);

        // Then
        assertThat(result).isEqualTo(0);
    }
}
