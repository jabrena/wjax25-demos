package info.jab.eulerproblems.eulerproblem1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test suite for Euler Problem 1.
 * 
 * Problem: Find the sum of all multiples of 3 or 5 below 1000.
 * 
 * Example: If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 */
@DisplayName("Euler Problem 1 Tests")
class EulerProblem1Test {

    private final EulerProblem1 solution = new EulerProblem1();

    @Test
    @DisplayName("Should return 23 for multiples of 3 or 5 below 10")
    void shouldReturnCorrectSumForExample() {
        // Given
        int limit = 10;

        // When
        long result = solution.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(23);
    }

    @Test
    @DisplayName("Should return 0 for limit below 3")
    void shouldReturnZeroForLimitBelow3() {
        // Given
        int limit = 2;

        // When
        long result = solution.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Should return correct sum for multiples of 3 or 5 below 1000")
    void shouldReturnCorrectSumForProblem() {
        // Given
        int limit = 1000;

        // When
        long result = solution.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(233168);
    }

    @Test
    @DisplayName("Should handle edge case with limit equal to 3")
    void shouldHandleLimitEqualTo3() {
        // Given
        int limit = 3;

        // When
        long result = solution.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Should handle edge case with limit equal to 5")
    void shouldHandleLimitEqualTo5() {
        // Given
        int limit = 5;

        // When
        long result = solution.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(3);
    }
}
