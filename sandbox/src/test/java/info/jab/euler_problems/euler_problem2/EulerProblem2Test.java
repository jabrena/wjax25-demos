package info.jab.euler_problems.euler_problem2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem #2.
 * 
 * Problem: By considering the terms in the Fibonacci sequence whose values 
 * do not exceed four million, find the sum of the even-valued terms.
 */
@DisplayName("Euler Problem #2 Tests")
class EulerProblem2Test {

    @Test
    @DisplayName("Should calculate sum of even Fibonacci terms not exceeding four million")
    void shouldCalculateSumOfEvenFibonacciTerms() {
        // Given
        EulerProblem2 problem = new EulerProblem2();
        long maxValue = 4_000_000L;

        // When
        long result = problem.sumEvenFibonacciTerms(maxValue);

        // Then
        assertThat(result).isEqualTo(4613732L);
    }

    @Test
    @DisplayName("Should calculate sum of even Fibonacci terms for small limit")
    void shouldCalculateSumForSmallLimit() {
        // Given
        EulerProblem2 problem = new EulerProblem2();
        long maxValue = 100L;

        // When
        long result = problem.sumEvenFibonacciTerms(maxValue);

        // Then
        // Fibonacci sequence: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
        // Even terms <= 100: 2, 8, 34
        // Sum: 2 + 8 + 34 = 44
        assertThat(result).isEqualTo(44L);
    }

    @Test
    @DisplayName("Should return zero for limit less than first even term")
    void shouldReturnZeroForLimitLessThanFirstEvenTerm() {
        // Given
        EulerProblem2 problem = new EulerProblem2();
        long maxValue = 1L;

        // When
        long result = problem.sumEvenFibonacciTerms(maxValue);

        // Then
        assertThat(result).isEqualTo(0L);
    }
}
