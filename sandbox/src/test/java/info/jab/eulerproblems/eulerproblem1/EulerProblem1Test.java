package info.jab.eulerproblems.eulerproblem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem #1.
 * 
 * Problem: Find the sum of all the multiples of 3 or 5 below 1000.
 * Example: For numbers below 10, the multiples are 3, 5, 6, 9, and their sum is 23.
 */
@DisplayName("Euler Problem #1 Tests")
class EulerProblem1Test {

    private EulerProblem1 solver;

    @BeforeEach
    void setUp() {
        solver = new EulerProblem1();
    }

    @Test
    @DisplayName("Should return 23 for multiples of 3 or 5 below 10")
    void shouldReturnCorrectSumForExample() {
        // Given
        int limit = 10;

        // When
        long result = solver.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(23L);
    }

    @Test
    @DisplayName("Should return 233168 for multiples of 3 or 5 below 1000")
    void shouldReturnCorrectSumForProblem() {
        // Given
        int limit = 1000;

        // When
        long result = solver.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(233168L);
    }

    @Test
    @DisplayName("Should return 0 for limit less than 3")
    void shouldReturnZeroForLimitLessThanThree() {
        // Given
        int limit = 2;

        // When
        long result = solver.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(0L);
    }

    @Test
    @DisplayName("Should handle limit exactly at 3")
    void shouldHandleLimitExactlyAtThree() {
        // Given
        int limit = 3;

        // When
        long result = solver.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(0L);
    }

    @Test
    @DisplayName("Should handle limit exactly at 5")
    void shouldHandleLimitExactlyAtFive() {
        // Given
        int limit = 5;

        // When
        long result = solver.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(3L);
    }

}
