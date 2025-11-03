package info.jab.eulerproblems.eulerproblem6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test suite for Project Euler Problem 6: Sum Square Difference
 * 
 * Problem: Find the difference between the sum of the squares of the first 
 * one hundred natural numbers and the square of the sum.
 */
@DisplayName("Euler Problem 6 Tests")
class EulerProblem6Test {

    private EulerProblem6 solution = new EulerProblem6();

    @Test
    @DisplayName("Should calculate the difference for n=10 correctly")
    void shouldCalculateDifferenceForTen() {
        // Given
        int n = 10;

        // When
        long result = solution.calculateDifference(n);

        // Then
        assertThat(result).isEqualTo(2640L);
    }

    @Test
    @DisplayName("Should calculate the difference for n=100 correctly")
    void shouldCalculateDifferenceForHundred() {
        // Given
        int n = 100;

        // When
        long result = solution.calculateDifference(n);

        // Then
        assertThat(result).isEqualTo(25164150L);
    }

    @ParameterizedTest
    @DisplayName("Should calculate the difference for various values")
    @CsvSource({
        "1, 0",
        "2, 4",
        "3, 22",
        "4, 70",
        "5, 170",
        "10, 2640",
        "100, 25164150"
    })
    void shouldCalculateDifferenceForVariousValues(int n, long expected) {
        // When
        long result = solution.calculateDifference(n);

        // Then
        assertThat(result).isEqualTo(expected);
    }
}
