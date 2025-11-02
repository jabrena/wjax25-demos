package info.jab.euler_problems.euler_problem1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 1: Multiples of 3 or 5.
 * 
 * Problem: Find the sum of all multiples of 3 or 5 below 1000.
 */
@DisplayName("Euler Problem 1 Tests")
class EulerProblem1Test {

    private final EulerProblem1 solution = new EulerProblem1();

    @Test
    @DisplayName("Should calculate the sum of multiples of 3 or 5 below 1000")
    void shouldCalculateSumOfMultiplesBelow1000() {
        // Given
        int limit = 1000;

        // When
        long result = solution.sumOfMultiples(limit);

        // Then
        assertThat(result).isEqualTo(233168L);
    }

    @Test
    @DisplayName("Should calculate the sum of multiples of 3 or 5 below 10")
    void shouldCalculateSumOfMultiplesBelow10() {
        // Given
        // Multiples of 3 or 5 below 10: 3, 5, 6, 9
        // Sum = 3 + 5 + 6 + 9 = 23
        int limit = 10;

        // When
        long result = solution.sumOfMultiples(limit);

        // Then
        assertThat(result).isEqualTo(23L);
    }

    @Test
    @DisplayName("Should return zero for limit less than 3")
    void shouldReturnZeroForLimitLessThan3() {
        // Given
        int limit = 2;

        // When
        long result = solution.sumOfMultiples(limit);

        // Then
        assertThat(result).isEqualTo(0L);
    }

    @Test
    @DisplayName("Should handle edge case where limit is 3")
    void shouldHandleLimitEqualTo3() {
        // Given
        int limit = 3;

        // When
        long result = solution.sumOfMultiples(limit);

        // Then
        assertThat(result).isEqualTo(0L); // No multiples below 3
    }
}
