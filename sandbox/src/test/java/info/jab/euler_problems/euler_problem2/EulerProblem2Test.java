package info.jab.euler_problems.euler_problem2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 2.
 * Problem: By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms.
 */
@DisplayName("Euler Problem 2 Tests")
class EulerProblem2Test {

    private EulerProblem2 solution = new EulerProblem2();

    @Test
    @DisplayName("Should calculate sum of even Fibonacci terms up to 4 million")
    void shouldCalculateSumOfEvenFibonacciTermsUpToFourMillion() {
        // Given
        long limit = 4_000_000L;

        // When
        long result = solution.sumEvenFibonacciTerms(limit);

        // Then
        assertThat(result).isPositive();
        // The expected result for Euler Problem 2 is 4613732
        assertThat(result).isEqualTo(4613732L);
    }

    @Test
    @DisplayName("Should handle small limit correctly")
    void shouldHandleSmallLimit() {
        // Given
        long limit = 10L;

        // When
        long result = solution.sumEvenFibonacciTerms(limit);

        // Then
        // Fibonacci terms up to 10: 1, 2, 3, 5, 8
        // Even terms: 2, 8
        // Sum: 10
        assertThat(result).isEqualTo(10L);
    }

    @Test
    @DisplayName("Should handle limit of 1")
    void shouldHandleLimitOfOne() {
        // Given
        long limit = 1L;

        // When
        long result = solution.sumEvenFibonacciTerms(limit);

        // Then
        // No even terms in sequence: 1
        assertThat(result).isEqualTo(0L);
    }

    @Test
    @DisplayName("Should handle limit of 2")
    void shouldHandleLimitOfTwo() {
        // Given
        long limit = 2L;

        // When
        long result = solution.sumEvenFibonacciTerms(limit);

        // Then
        // Even terms: 2
        assertThat(result).isEqualTo(2L);
    }
}
