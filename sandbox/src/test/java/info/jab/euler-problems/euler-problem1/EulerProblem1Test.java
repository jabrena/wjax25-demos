package info.jab.euler_problems.euler_problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 1: Multiples of 3 or 5
 * 
 * Problem statement:
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * 
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
@DisplayName("Euler Problem 1 Tests")
class EulerProblem1Test {

    private EulerProblem1 problem1;

    @BeforeEach
    void setUp() {
        problem1 = new EulerProblem1();
    }

    @Test
    @DisplayName("Should calculate sum of multiples below 10 correctly")
    void shouldCalculateSumBelow10() {
        // Given
        int limit = 10;

        // When
        long result = problem1.solve(limit);

        // Then
        // Multiples of 3 or 5 below 10: 3, 5, 6, 9. Sum = 23
        assertThat(result).isEqualTo(23L);
    }

    @Test
    @DisplayName("Should calculate sum of multiples below 1000 correctly")
    void shouldCalculateSumBelow1000() {
        // Given
        int limit = 1000;

        // When
        long result = problem1.solve(limit);

        // Then
        // The expected result for Euler Problem 1
        assertThat(result).isGreaterThan(0L);
        // We'll verify this is correct after implementation
        // Expected: 233168
        assertThat(result).isEqualTo(233168L);
    }

    @Test
    @DisplayName("Should return zero for limit less than 3")
    void shouldReturnZeroForSmallLimit() {
        // Given
        int limit = 2;

        // When
        long result = problem1.solve(limit);

        // Then
        assertThat(result).isEqualTo(0L);
    }

    @Test
    @DisplayName("Should handle edge case of limit 3")
    void shouldHandleLimitThree() {
        // Given
        int limit = 3;

        // When
        long result = problem1.solve(limit);

        // Then
        // No multiples below 3
        assertThat(result).isEqualTo(0L);
    }

    @Test
    @DisplayName("Should handle limit 5 correctly")
    void shouldHandleLimitFive() {
        // Given
        int limit = 5;

        // When
        long result = problem1.solve(limit);

        // Then
        // Multiples below 5: 3. Sum = 3
        assertThat(result).isEqualTo(3L);
    }
}