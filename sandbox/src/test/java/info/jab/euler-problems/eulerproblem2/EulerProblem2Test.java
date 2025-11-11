package info.jab.euler-problems.eulerproblem2;

import org.junit.jupiter.api.BeforeEach;
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

    private EulerProblem2 solution;

    @BeforeEach
    void setUp() {
        solution = new EulerProblem2();
    }

    @Test
    @DisplayName("Should calculate sum of even Fibonacci terms not exceeding four million")
    void shouldCalculateSumOfEvenFibonacciTermsNotExceedingFourMillion() {
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
        // Given
        long maxValue = 10L;

        // When
        long result = solution.sumEvenFibonacciTerms(maxValue);

        // Then
        // Fibonacci sequence up to 10: 1, 1, 2, 3, 5, 8
        // Even terms: 2, 8
        // Sum: 2 + 8 = 10
        assertThat(result).isEqualTo(10L);
    }

    @Test
    @DisplayName("Should return zero for limit less than first even Fibonacci number")
    void shouldReturnZeroForLimitLessThanFirstEvenFibonacciNumber() {
        // Given
        long maxValue = 1L;

        // When
        long result = solution.sumEvenFibonacciTerms(maxValue);

        // Then
        assertThat(result).isEqualTo(0L);
    }
}
