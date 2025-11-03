package info.jab.euler_problems.euler_problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 2.
 * Problem: Find the sum of all even-valued terms in the Fibonacci sequence 
 * whose values do not exceed four million.
 */
@DisplayName("Euler Problem 2 Tests")
class EulerProblem2Test {

    private EulerProblem2 solver;

    @BeforeEach
    void setUp() {
        solver = new EulerProblem2();
    }

    @Test
    @DisplayName("Should calculate sum of even Fibonacci terms not exceeding four million")
    void shouldCalculateSumOfEvenFibonacciTerms() {
        // Given
        long maxValue = 4_000_000L;

        // When
        long result = solver.sumEvenFibonacciTerms(maxValue);

        // Then
        assertThat(result).isEqualTo(4613732L);
    }

    @Test
    @DisplayName("Should calculate sum correctly for small limit")
    void shouldCalculateSumForSmallLimit() {
        // Given
        long maxValue = 100L;

        // When
        long result = solver.sumEvenFibonacciTerms(maxValue);

        // Then
        // Fibonacci sequence: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
        // Even terms: 2, 8, 34
        // Sum: 2 + 8 + 34 = 44
        assertThat(result).isEqualTo(44L);
    }

    @Test
    @DisplayName("Should return 0 for limit less than 2")
    void shouldReturnZeroForLimitLessThanTwo() {
        // Given
        long maxValue = 1L;

        // When
        long result = solver.sumEvenFibonacciTerms(maxValue);

        // Then
        assertThat(result).isEqualTo(0L);
    }

    @Test
    @DisplayName("Should return 2 for limit exactly 2")
    void shouldReturnTwoForLimitExactlyTwo() {
        // Given
        long maxValue = 2L;

        // When
        long result = solver.sumEvenFibonacciTerms(maxValue);

        // Then
        assertThat(result).isEqualTo(2L);
    }
}
