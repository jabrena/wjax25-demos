package info.jab.eulerproblems.eulerproblem2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test suite for Euler Problem 2.
 * 
 * Problem: By considering the terms in the Fibonacci sequence whose values 
 * do not exceed four million, find the sum of the even-valued terms.
 */
@DisplayName("Euler Problem 2 Tests")
class EulerProblem2Test {

    private final EulerProblem2 solution = new EulerProblem2();

    @Test
    @DisplayName("Should calculate sum of even Fibonacci terms up to 4 million")
    void shouldCalculateSumOfEvenFibonacciTermsUpToFourMillion() {
        // Given
        long maxValue = 4_000_000L;

        // When
        long result = solution.sumEvenFibonacciTerms(maxValue);

        // Then
        assertThat(result).isEqualTo(4613732L);
    }

    @Test
    @DisplayName("Should calculate sum of even Fibonacci terms for small limit")
    void shouldCalculateSumOfEvenFibonacciTermsForSmallLimit() {
        // Given - Fibonacci sequence: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
        // Even terms up to 10: 2, 8 -> sum = 10
        long maxValue = 10L;

        // When
        long result = solution.sumEvenFibonacciTerms(maxValue);

        // Then
        assertThat(result).isEqualTo(10L);
    }

    @Test
    @DisplayName("Should return zero for limit less than first even term")
    void shouldReturnZeroForLimitLessThanFirstEvenTerm() {
        // Given
        long maxValue = 1L;

        // When
        long result = solution.sumEvenFibonacciTerms(maxValue);

        // Then
        assertThat(result).isEqualTo(0L);
    }

    @Test
    @DisplayName("Should handle limit equal to first even term")
    void shouldHandleLimitEqualToFirstEvenTerm() {
        // Given
        long maxValue = 2L;

        // When
        long result = solution.sumEvenFibonacciTerms(maxValue);

        // Then
        assertThat(result).isEqualTo(2L);
    }
}
