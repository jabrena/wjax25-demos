package info.jab.eulerproblems.eulerproblem2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test suite for Euler Problem 2.
 * Problem: By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms.
 */
@DisplayName("Euler Problem 2 Tests")
class EulerProblem2Test {

    private final EulerProblem2 solution = new EulerProblem2();

    @Test
    @DisplayName("Should calculate sum of even Fibonacci numbers up to 4 million")
    void shouldCalculateSumOfEvenFibonacciNumbersUpToFourMillion() {
        // Given
        long limit = 4_000_000L;

        // When
        long result = solution.sumEvenFibonacciNumbers(limit);

        // Then
        assertThat(result).isEqualTo(4613732L);
    }

    @Test
    @DisplayName("Should calculate sum of even Fibonacci numbers up to 10")
    void shouldCalculateSumOfEvenFibonacciNumbersUpToTen() {
        // Given
        long limit = 10L;

        // When
        long result = solution.sumEvenFibonacciNumbers(limit);

        // Then
        // Fibonacci sequence up to 10: 1, 1, 2, 3, 5, 8
        // Even values: 2, 8
        // Sum: 2 + 8 = 10
        assertThat(result).isEqualTo(10L);
    }

    @Test
    @DisplayName("Should return 0 for limit less than 2")
    void shouldReturnZeroForLimitLessThanTwo() {
        // Given
        long limit = 1L;

        // When
        long result = solution.sumEvenFibonacciNumbers(limit);

        // Then
        assertThat(result).isEqualTo(0L);
    }

    @Test
    @DisplayName("Should calculate sum of even Fibonacci numbers up to 100")
    void shouldCalculateSumOfEvenFibonacciNumbersUpToHundred() {
        // Given
        long limit = 100L;

        // When
        long result = solution.sumEvenFibonacciNumbers(limit);

        // Then
        // Fibonacci sequence up to 100: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
        // Even values: 2, 8, 34
        // Sum: 2 + 8 + 34 = 44
        assertThat(result).isEqualTo(44L);
    }
}
