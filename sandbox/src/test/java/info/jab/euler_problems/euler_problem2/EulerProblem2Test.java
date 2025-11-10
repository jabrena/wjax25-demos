package info.jab.euler_problems.euler_problem2;

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

    private EulerProblem2 solver;

    @BeforeEach
    void setUp() {
        solver = new EulerProblem2();
    }

    @Test
    @DisplayName("Should calculate sum of even Fibonacci numbers up to 4 million")
    void shouldCalculateSumOfEvenFibonacciNumbersUpToFourMillion() {
        // Given
        long limit = 4_000_000L;

        // When
        long result = solver.sumEvenFibonacciNumbers(limit);

        // Then
        assertThat(result).isEqualTo(4613732L);
    }

    @Test
    @DisplayName("Should calculate sum of even Fibonacci numbers up to 100")
    void shouldCalculateSumOfEvenFibonacciNumbersUpToHundred() {
        // Given
        long limit = 100L;
        // Even Fibonacci numbers up to 100: 2, 8, 34 = 44

        // When
        long result = solver.sumEvenFibonacciNumbers(limit);

        // Then
        assertThat(result).isEqualTo(44L);
    }

    @Test
    @DisplayName("Should return 0 for limit less than 2")
    void shouldReturnZeroForLimitLessThanTwo() {
        // Given
        long limit = 1L;

        // When
        long result = solver.sumEvenFibonacciNumbers(limit);

        // Then
        assertThat(result).isEqualTo(0L);
    }

    @Test
    @DisplayName("Should return 2 for limit of 2")
    void shouldReturnTwoForLimitOfTwo() {
        // Given
        long limit = 2L;

        // When
        long result = solver.sumEvenFibonacciNumbers(limit);

        // Then
        assertThat(result).isEqualTo(2L);
    }
}
