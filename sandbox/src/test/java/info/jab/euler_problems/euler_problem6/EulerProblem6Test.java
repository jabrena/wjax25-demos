package info.jab.euler_problems.euler_problem6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test suite for Euler Problem 6.
 * Problem: Find the difference between the sum of squares and the square of the sum
 * of the first N natural numbers.
 */
@DisplayName("Euler Problem 6 Tests")
class EulerProblem6Test {

    private EulerProblem6 problem6;

    @BeforeEach
    void setUp() {
        problem6 = new EulerProblem6();
    }

    @Test
    @DisplayName("Should calculate difference for first 10 natural numbers")
    void shouldCalculateDifferenceForFirstTenNumbers() {
        // Given
        int n = 10;

        // When
        long result = problem6.solve(n);

        // Then
        assertThat(result).isEqualTo(2640L);
    }

    @Test
    @DisplayName("Should calculate difference for first 100 natural numbers")
    void shouldCalculateDifferenceForFirstHundredNumbers() {
        // Given
        int n = 100;

        // When
        long result = problem6.solve(n);

        // Then - The expected result for Euler Problem 6
        assertThat(result).isEqualTo(25164150L);
    }

    @ParameterizedTest
    @DisplayName("Should calculate difference for various values of N")
    @CsvSource({
        "1, 0",
        "2, 4",
        "3, 22",
        "5, 170",
        "10, 2640"
    })
    void shouldCalculateDifferenceForVariousValues(int n, long expected) {
        // When
        long result = problem6.solve(n);

        // Then
        assertThat(result).isEqualTo(expected);
    }
}
