package info.jab.euler_problems.euler_problem2;

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

    private final EulerProblem2 solution = new EulerProblem2();

    @Test
    @DisplayName("Should calculate sum of even Fibonacci numbers up to 4,000,000")
    void shouldCalculateSumOfEvenFibonacciNumbersUpToFourMillion() {
        // Given
        long maxValue = 4_000_000L;

        // When
        long result = solution.sumEvenFibonacciNumbers(maxValue);

        // Then
        assertThat(result).isEqualTo(4_613_732L);
    }

    @Test
    @DisplayName("Should calculate sum of even Fibonacci numbers up to 100")
    void shouldCalculateSumOfEvenFibonacciNumbersUpToHundred() {
        // Given
        // Fibonacci sequence: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
        // Even numbers: 2, 8, 34
        // Sum: 2 + 8 + 34 = 44
        long maxValue = 100L;

        // When
        long result = solution.sumEvenFibonacciNumbers(maxValue);

        // Then
        assertThat(result).isEqualTo(44L);
    }

    @Test
    @DisplayName("Should return 0 for max value less than 2")
    void shouldReturnZeroForMaxValueLessThanTwo() {
        // Given
        long maxValue = 1L;

        // When
        long result = solution.sumEvenFibonacciNumbers(maxValue);

        // Then
        assertThat(result).isEqualTo(0L);
    }

    @Test
    @DisplayName("Should return 2 for max value equal to 2")
    void shouldReturnTwoForMaxValueEqualToTwo() {
        // Given
        long maxValue = 2L;

        // When
        long result = solution.sumEvenFibonacciNumbers(maxValue);

        // Then
        assertThat(result).isEqualTo(2L);
    }
}
