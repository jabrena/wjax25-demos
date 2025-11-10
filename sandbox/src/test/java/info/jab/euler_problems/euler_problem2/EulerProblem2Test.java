package info.jab.euler_problems.euler_problem2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 2.
 * Problem: Find the sum of even-valued Fibonacci terms that don't exceed four million.
 */
@DisplayName("Euler Problem 2 Tests")
class EulerProblem2Test {

    private EulerProblem2 solution = new EulerProblem2();

    @Test
    @DisplayName("Should calculate sum of even Fibonacci terms up to 4,000,000")
    void shouldCalculateSumOfEvenFibonacciTermsUpToFourMillion() {
        // Given
        long limit = 4_000_000L;

        // When
        long result = solution.sumOfEvenFibonacciTerms(limit);

        // Then
        assertThat(result).isEqualTo(4_613_732L);
    }

    @Test
    @DisplayName("Should calculate sum of even Fibonacci terms up to 100")
    void shouldCalculateSumOfEvenFibonacciTermsUpToHundred() {
        // Given
        long limit = 100L;
        // Fibonacci terms up to 100: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
        // Even terms: 2, 8, 34
        // Sum: 2 + 8 + 34 = 44

        // When
        long result = solution.sumOfEvenFibonacciTerms(limit);

        // Then
        assertThat(result).isEqualTo(44L);
    }

    @Test
    @DisplayName("Should return 0 for limit less than 2")
    void shouldReturnZeroForLimitLessThanTwo() {
        // Given
        long limit = 1L;

        // When
        long result = solution.sumOfEvenFibonacciTerms(limit);

        // Then
        assertThat(result).isEqualTo(0L);
    }

    @Test
    @DisplayName("Should return 2 for limit equal to 2")
    void shouldReturnTwoForLimitEqualToTwo() {
        // Given
        long limit = 2L;

        // When
        long result = solution.sumOfEvenFibonacciTerms(limit);

        // Then
        assertThat(result).isEqualTo(2L);
    }
}
