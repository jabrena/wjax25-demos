package info.jab.eulerproblems.eulerproblem2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 2.
 * Problem: Find the sum of the even-valued terms in the Fibonacci sequence
 * whose values do not exceed four million.
 */
@DisplayName("Euler Problem 2 Tests")
class EulerProblem2Test {

    @Test
    @DisplayName("Should calculate the sum of even Fibonacci numbers below 4,000,000")
    void shouldCalculateSumOfEvenFibonacciNumbersBelowFourMillion() {
        // Given
        long limit = 4_000_000L;

        // When
        long result = EulerProblem2.sumOfEvenFibonacciNumbers(limit);

        // Then
        assertThat(result).isEqualTo(4_613_732L);
    }

    @Test
    @DisplayName("Should calculate the sum of even Fibonacci numbers below 100")
    void shouldCalculateSumOfEvenFibonacciNumbersBelowHundred() {
        // Given
        // Fibonacci sequence: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
        // Even values below 100: 2, 8, 34
        // Sum = 44
        long limit = 100L;

        // When
        long result = EulerProblem2.sumOfEvenFibonacciNumbers(limit);

        // Then
        assertThat(result).isEqualTo(44L);
    }

    @Test
    @DisplayName("Should return 0 for limit below 2")
    void shouldReturnZeroForLimitBelowTwo() {
        // Given
        long limit = 1L;

        // When
        long result = EulerProblem2.sumOfEvenFibonacciNumbers(limit);

        // Then
        assertThat(result).isEqualTo(0L);
    }
}
