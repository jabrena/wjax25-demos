package info.jab.euler_problems.euler_problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 1.
 * Problem: Find the sum of all multiples of 3 or 5 below 1000.
 * Example: If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 */
@DisplayName("Euler Problem 1 Tests")
class EulerProblem1Test {

    private EulerProblem1 solver;

    @BeforeEach
    void setUp() {
        solver = new EulerProblem1();
    }

    @Test
    @DisplayName("Should return correct sum for multiples below 10")
    void shouldReturnCorrectSumForMultiplesBelow10() {
        // Given
        int limit = 10;

        // When
        long result = solver.sumMultiples(limit);

        // Then
        assertThat(result).isEqualTo(23);
    }

    @Test
    @DisplayName("Should return correct sum for multiples below 1000")
    void shouldReturnCorrectSumForMultiplesBelow1000() {
        // Given
        int limit = 1000;

        // When
        long result = solver.sumMultiples(limit);

        // Then
        assertThat(result).isEqualTo(233168);
    }

    @Test
    @DisplayName("Should return 0 for limit less than 3")
    void shouldReturnZeroForLimitLessThanThree() {
        // Given
        int limit = 2;

        // When
        long result = solver.sumMultiples(limit);

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Should return 3 for limit 4")
    void shouldReturnThreeForLimitFour() {
        // Given
        int limit = 4;

        // When
        long result = solver.sumMultiples(limit);

        // Then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("Should return 8 for limit 6")
    void shouldReturnEightForLimitSix() {
        // Given
        int limit = 6;

        // When
        long result = solver.sumMultiples(limit);

        // Then
        assertThat(result).isEqualTo(8); // 3 + 5
    }

    @Test
    @DisplayName("Should return 14 for limit 7")
    void shouldReturnFourteenForLimitSeven() {
        // Given
        int limit = 7;

        // When
        long result = solver.sumMultiples(limit);

        // Then
        assertThat(result).isEqualTo(14); // 3 + 5 + 6
    }
}
