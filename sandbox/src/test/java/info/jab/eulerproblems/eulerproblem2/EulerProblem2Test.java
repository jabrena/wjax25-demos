package info.jab.eulerproblems.eulerproblem2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for Euler Problem #2.
 * Problem: Find the sum of all even Fibonacci numbers that do not exceed four million.
 * Starting with 1 and 2, the Fibonacci sequence begins: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89...
 */
@DisplayName("Euler Problem #2 Tests")
class EulerProblem2Test {

    @Test
    @DisplayName("Should return the sum of even Fibonacci numbers up to 4,000,000")
    void shouldReturnSumOfEvenFibonacciNumbersUpToFourMillion() {
        // Given
        EulerProblem2 problem = new EulerProblem2();
        long expectedSum = 4613732L;

        // When
        long result = problem.solve();

        // Then
        assertThat(result).isEqualTo(expectedSum);
    }

    @Test
    @DisplayName("Should return sum of even Fibonacci numbers up to 100")
    void shouldReturnSumOfEvenFibonacciNumbersUpToHundred() {
        // Given
        EulerProblem2 problem = new EulerProblem2();
        // Even Fibonacci numbers up to 100: 2, 8, 34 = 44
        long expectedSum = 44L;

        // When
        long result = problem.solve(100);

        // Then
        assertThat(result).isEqualTo(expectedSum);
    }
}
