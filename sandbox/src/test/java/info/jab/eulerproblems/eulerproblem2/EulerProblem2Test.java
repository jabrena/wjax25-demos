package info.jab.eulerproblems.eulerproblem2;

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
    @DisplayName("Should calculate sum of even Fibonacci numbers not exceeding 4,000,000")
    void shouldCalculateSumOfEvenFibonacciNumbers() {
        // Given
        long limit = 4_000_000L;

        // When
        long result = solution.sumEvenFibonacciNumbers(limit);

        // Then
        assertThat(result).isEqualTo(4_613_732L);
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
    @DisplayName("Should return 2 for limit of 2")
    void shouldReturnTwoForLimitOfTwo() {
        // Given
        long limit = 2L;

        // When
        long result = solution.sumEvenFibonacciNumbers(limit);

        // Then
        assertThat(result).isEqualTo(2L);
    }

    @Test
    @DisplayName("Should return 2 for limit of 3")
    void shouldReturnTwoForLimitOfThree() {
        // Given
        long limit = 3L;

        // When
        long result = solution.sumEvenFibonacciNumbers(limit);

        // Then
        assertThat(result).isEqualTo(2L);
    }

    @Test
    @DisplayName("Should return 10 for limit of 10 (2 + 8)")
    void shouldReturnTenForLimitOfTen() {
        // Given
        long limit = 10L;

        // When
        long result = solution.sumEvenFibonacciNumbers(limit);

        // Then
        assertThat(result).isEqualTo(10L); // 2 + 8
    }

    @Test
    @DisplayName("Should return 44 for limit of 50 (2 + 8 + 34)")
    void shouldReturnFortyFourForLimitOfFifty() {
        // Given
        long limit = 50L;

        // When
        long result = solution.sumEvenFibonacciNumbers(limit);

        // Then
        assertThat(result).isEqualTo(44L); // 2 + 8 + 34
    }
}
