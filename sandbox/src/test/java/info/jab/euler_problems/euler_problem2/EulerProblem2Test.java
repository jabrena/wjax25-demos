package info.jab.euler_problems.euler_problem2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem #2.
 * Problem: By considering the terms in the Fibonacci sequence whose values do not exceed
 * four million, find the sum of the even-valued terms.
 */
@DisplayName("Euler Problem #2 Tests")
class EulerProblem2Test {

    @Test
    @DisplayName("Should return the sum of even-valued Fibonacci terms not exceeding four million")
    void shouldReturnSumOfEvenFibonacciTerms() {
        // Given
        EulerProblem2 solution = new EulerProblem2();

        // When
        long result = solution.solve();

        // Then
        assertThat(result).isEqualTo(4613732L);
    }

    @Test
    @DisplayName("Should return the sum of even-valued Fibonacci terms for a given limit")
    void shouldReturnSumOfEvenFibonacciTermsWithLimit() {
        // Given
        EulerProblem2 solution = new EulerProblem2();
        long limit = 100; // Sum of even Fibonacci terms: 2 + 8 + 34 = 44

        // When
        long result = solution.solve(limit);

        // Then
        assertThat(result).isEqualTo(44L);
    }

    @Test
    @DisplayName("Should return zero for limit less than first even Fibonacci number")
    void shouldReturnZeroForSmallLimit() {
        // Given
        EulerProblem2 solution = new EulerProblem2();
        long limit = 1;

        // When
        long result = solution.solve(limit);

        // Then
        assertThat(result).isEqualTo(0L);
    }

    @Test
    @DisplayName("Should handle limit exactly at a Fibonacci number")
    void shouldHandleLimitAtFibonacciNumber() {
        // Given
        EulerProblem2 solution = new EulerProblem2();
        long limit = 8; // Sum of even Fibonacci terms: 2 + 8 = 10

        // When
        long result = solution.solve(limit);

        // Then
        assertThat(result).isEqualTo(10L);
    }
}
