package info.jab.euler_problems.euler_problem1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 1.
 * Problem: Find the sum of all multiples of 3 or 5 below 1000.
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
        long result = solution.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(23);
    }

    @Test
    @DisplayName("Should return 0 for limit 0")
    void shouldReturn0ForLimit0() {
        // Given
        int limit = 0;

        // When
        long result = solution.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Should return 0 for limit 3 (exclusive)")
    void shouldReturn0ForLimit3() {
        // Given
        int limit = 3;

        // When
        long result = solution.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Should return 3 for limit 5")
    void shouldReturn3ForLimit5() {
        // Given
        int limit = 5;

        // When
        long result = solution.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("Should return correct sum for multiples below 1000")
    void shouldReturnCorrectSumForMultiplesBelow1000() {
        // Given
        int limit = 1000;

        // When
        long result = solution.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(233168);
    }
}
