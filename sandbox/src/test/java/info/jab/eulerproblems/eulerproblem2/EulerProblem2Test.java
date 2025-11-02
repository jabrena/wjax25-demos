package info.jab.eulerproblems.eulerproblem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test suite for Euler Problem 2.
 * Problem: Find the sum of even-valued terms in the Fibonacci sequence
 * (starting with 1 and 2) whose values do not exceed four million.
 */
@DisplayName("Euler Problem 2 Tests")
class EulerProblem2Test {

    private EulerProblem2 eulerProblem2;

    @BeforeEach
    void setUp() {
        eulerProblem2 = new EulerProblem2();
    }

    @Test
    @DisplayName("Should calculate sum of even Fibonacci terms up to four million")
    void shouldCalculateSumOfEvenFibonacciTermsUpToFourMillion() {
        // Given
        long limit = 4_000_000L;

        // When
        long result = eulerProblem2.sumEvenFibonacciTerms(limit);

        // Then
        assertThat(result).isEqualTo(4613732L);
    }

    @Test
    @DisplayName("Should calculate sum of even Fibonacci terms for small limit")
    void shouldCalculateSumOfEvenFibonacciTermsForSmallLimit() {
        // Given
        long limit = 100L;

        // When
        long result = eulerProblem2.sumEvenFibonacciTerms(limit);

        // Then - Fibonacci sequence up to 100: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
        // Even terms: 2, 8, 34 = 44
        assertThat(result).isEqualTo(44L);
    }

    @Test
    @DisplayName("Should return 0 for limit less than 2")
    void shouldReturnZeroForLimitLessThanTwo() {
        // Given
        long limit = 1L;

        // When
        long result = eulerProblem2.sumEvenFibonacciTerms(limit);

        // Then
        assertThat(result).isEqualTo(0L);
    }
}