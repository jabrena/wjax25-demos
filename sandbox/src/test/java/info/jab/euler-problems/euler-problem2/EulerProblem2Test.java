package info.jab.euler-problems.euler-problem2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for Euler Problem 2.
 * 
 * Problem: By considering the terms in the Fibonacci sequence whose values 
 * do not exceed four million, find the sum of the even-valued terms.
 */
@DisplayName("Euler Problem 2 Tests")
class EulerProblem2Test {

    private EulerProblem2 solution = new EulerProblem2();

    @Test
    @DisplayName("Should calculate sum of even Fibonacci terms up to 4 million")
    void shouldCalculateSumOfEvenFibonacciTermsUpToFourMillion() {
        // Given
        int limit = 4_000_000;

        // When
        long result = solution.sumEvenFibonacciTerms(limit);

        // Then
        assertThat(result).isEqualTo(4613732L);
    }

    @Test
    @DisplayName("Should calculate sum of even Fibonacci terms up to 10")
    void shouldCalculateSumOfEvenFibonacciTermsUpToTen() {
        // Given
        int limit = 10;

        // When
        long result = solution.sumEvenFibonacciTerms(limit);

        // Then
        // Fibonacci sequence up to 10: 1, 2, 3, 5, 8
        // Even terms: 2, 8
        // Sum: 2 + 8 = 10
        assertThat(result).isEqualTo(10L);
    }

    @Test
    @DisplayName("Should calculate sum of even Fibonacci terms up to 100")
    void shouldCalculateSumOfEvenFibonacciTermsUpToHundred() {
        // Given
        int limit = 100;

        // When
        long result = solution.sumEvenFibonacciTerms(limit);

        // Then
        // Fibonacci sequence up to 100: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
        // Even terms: 2, 8, 34
        // Sum: 2 + 8 + 34 = 44
        assertThat(result).isEqualTo(44L);
    }

    @Test
    @DisplayName("Should return zero for limit less than 2")
    void shouldReturnZeroForLimitLessThanTwo() {
        // Given
        int limit = 1;

        // When
        long result = solution.sumEvenFibonacciTerms(limit);

        // Then
        assertThat(result).isEqualTo(0L);
    }
}
