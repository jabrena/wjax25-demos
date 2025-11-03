package info.jab.euler_problems.euler_problem2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 2:
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms.
 */
@DisplayName("Euler Problem 2 Tests")
class EulerProblem2Test {

    @Test
    @DisplayName("Should calculate sum of even Fibonacci numbers up to 4000000")
    void shouldCalculateSumOfEvenFibonacciNumbers() {
        // Given
        EulerProblem2 solver = new EulerProblem2();
        long limit = 4_000_000L;

        // When
        long result = solver.sumEvenFibonacciNumbers(limit);

        // Then
        assertThat(result).isEqualTo(4_613_732L);
    }

    @Test
    @DisplayName("Should handle small limit correctly")
    void shouldHandleSmallLimit() {
        // Given
        EulerProblem2 solver = new EulerProblem2();
        long limit = 10L;

        // When
        long result = solver.sumEvenFibonacciNumbers(limit);

        // Then
        // Fibonacci: 1, 2, 3, 5, 8, 13...
        // Even numbers <= 10: 2, 8
        // Sum: 2 + 8 = 10
        assertThat(result).isEqualTo(10L);
    }

    @Test
    @DisplayName("Should handle limit of 2")
    void shouldHandleLimitOfTwo() {
        // Given
        EulerProblem2 solver = new EulerProblem2();
        long limit = 2L;

        // When
        long result = solver.sumEvenFibonacciNumbers(limit);

        // Then
        // Only 2 is even and <= 2
        assertThat(result).isEqualTo(2L);
    }
}
