package info.jab.euler_problems.euler_problem1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 1.
 * Problem: Find the sum of all the multiples of 3 or 5 below 1000.
 */
@DisplayName("Euler Problem 1 Tests")
class EulerProblem1Test {

    @Test
    @DisplayName("Should return correct sum for multiples of 3 or 5 below 10")
    void shouldReturnCorrectSumForMultiplesBelow10() {
        // Given
        int limit = 10;

        // When
        long result = EulerProblem1.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(23); // 3 + 5 + 6 + 9 = 23
    }

    @Test
    @DisplayName("Should return correct sum for multiples of 3 or 5 below 1000")
    void shouldReturnCorrectSumForMultiplesBelow1000() {
        // Given
        int limit = 1000;

        // When
        long result = EulerProblem1.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(233168);
    }

    @Test
    @DisplayName("Should return 0 for limit below 3")
    void shouldReturnZeroForLimitBelow3() {
        // Given
        int limit = 2;

        // When
        long result = EulerProblem1.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Should handle edge case with limit 3")
    void shouldHandleEdgeCaseWithLimit3() {
        // Given
        int limit = 3;

        // When
        long result = EulerProblem1.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(0); // 3 is not below 3
    }
}
