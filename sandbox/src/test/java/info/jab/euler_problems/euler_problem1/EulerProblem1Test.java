package info.jab.euler_problems.euler_problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 1.
 * Problem: Find the sum of all multiples of 3 or 5 below a given number.
 */
@DisplayName("Euler Problem 1 Tests")
class EulerProblem1Test {

    private EulerProblem1 solution;

    @BeforeEach
    void setUp() {
        solution = new EulerProblem1();
    }

    @Test
    @DisplayName("Should calculate sum of multiples of 3 or 5 below 10")
    void shouldCalculateSumBelow10() {
        // Given
        int limit = 10;

        // When
        long result = solution.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(23);
    }

    @Test
    @DisplayName("Should calculate sum of multiples of 3 or 5 below 1000")
    void shouldCalculateSumBelow1000() {
        // Given
        int limit = 1000;

        // When
        long result = solution.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(233168);
    }

    @ParameterizedTest
    @DisplayName("Should calculate sum for various limits")
    @CsvSource({
        "1, 0",
        "3, 0",
        "4, 3",
        "5, 3",
        "6, 8",
        "10, 23",
        "20, 78",
        "100, 2318"
    })
    void shouldCalculateSumForVariousLimits(int limit, long expected) {
        long result = solution.sumMultiplesOf3Or5(limit);
        assertThat(result).isEqualTo(expected);
    }
}
