package info.jab.euler_problems.euler_problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 1.
 * Problem: Find the sum of all the multiples of 3 or 5 below 1000.
 */
@DisplayName("Euler Problem 1 Tests")
class EulerProblem1Test {

    private EulerProblem1 solution;

    @BeforeEach
    void setUp() {
        solution = new EulerProblem1();
    }

    @Test
    @DisplayName("Should return 0 for limit below 3")
    void shouldReturnZeroForLimitBelowThree() {
        // Given
        int limit = 2;

        // When
        long result = solution.sumMultiplesOfThreeOrFive(limit);

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Should return correct sum for limit 10")
    void shouldReturnCorrectSumForLimitTen() {
        // Given
        // Multiples of 3 or 5 below 10: 3, 5, 6, 9
        // Sum = 3 + 5 + 6 + 9 = 23
        int limit = 10;

        // When
        long result = solution.sumMultiplesOfThreeOrFive(limit);

        // Then
        assertThat(result).isEqualTo(23);
    }

    @Test
    @DisplayName("Should return correct sum for limit 20")
    void shouldReturnCorrectSumForLimitTwenty() {
        // Given
        // Multiples of 3 or 5 below 20: 3, 5, 6, 9, 10, 12, 15, 18
        // Sum = 3 + 5 + 6 + 9 + 10 + 12 + 15 + 18 = 78
        int limit = 20;

        // When
        long result = solution.sumMultiplesOfThreeOrFive(limit);

        // Then
        assertThat(result).isEqualTo(78);
    }

    @Test
    @DisplayName("Should handle numbers that are multiples of both 3 and 5 (15) correctly")
    void shouldHandleCommonMultiplesCorrectly() {
        // Given
        // Multiples of 3 or 5 below 16: 3, 5, 6, 9, 10, 12, 15
        // Sum = 3 + 5 + 6 + 9 + 10 + 12 + 15 = 60
        int limit = 16;

        // When
        long result = solution.sumMultiplesOfThreeOrFive(limit);

        // Then
        assertThat(result).isEqualTo(60);
    }

    @Test
    @DisplayName("Should return correct sum for limit 1000 (the actual problem)")
    void shouldReturnCorrectSumForLimitThousand() {
        // Given
        // This is the actual Euler Problem 1 requirement
        int limit = 1000;

        // When
        long result = solution.sumMultiplesOfThreeOrFive(limit);

        // Then
        // Expected answer: 233168
        assertThat(result).isEqualTo(233168);
    }
}
