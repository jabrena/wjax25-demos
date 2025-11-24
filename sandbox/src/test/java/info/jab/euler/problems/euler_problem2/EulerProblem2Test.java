package info.jab.euler.problems.euler_problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test suite for Project Euler Problem 2.
 * Problem statement: Find the sum of even-valued terms in the Fibonacci sequence
 * whose values do not exceed four million.
 */
@DisplayName("Euler Problem 2 Tests")
class EulerProblem2Test {

    private EulerProblem2 eulerProblem2;

    @BeforeEach
    void setUp() {
        eulerProblem2 = new EulerProblem2();
    }

    @Test
    @DisplayName("Should calculate sum of even Fibonacci numbers up to four million")
    void shouldCalculateSumOfEvenFibonacciNumbersUpToFourMillion() {
        long limit = 4_000_000L;

        long result = eulerProblem2.sumOfEvenFibonacciNumbers(limit);

        assertThat(result).isEqualTo(4_613_732L);
    }

    @Test
    @DisplayName("Should calculate sum of even Fibonacci numbers up to ten")
    void shouldCalculateSumOfEvenFibonacciNumbersUpToTen() {
        long limit = 10L;

        long result = eulerProblem2.sumOfEvenFibonacciNumbers(limit);

        assertThat(result).isEqualTo(10L);
    }

    @Test
    @DisplayName("Should calculate sum of even Fibonacci numbers up to one hundred")
    void shouldCalculateSumOfEvenFibonacciNumbersUpToHundred() {
        long limit = 100L;

        long result = eulerProblem2.sumOfEvenFibonacciNumbers(limit);

        assertThat(result).isEqualTo(44L);
    }

    @Test
    @DisplayName("Should return zero for limit less than two")
    void shouldReturnZeroForLimitLessThanTwo() {
        long limit = 1L;

        long result = eulerProblem2.sumOfEvenFibonacciNumbers(limit);

        assertThat(result).isEqualTo(0L);
    }

    @Test
    @DisplayName("Should return two for limit equal to two")
    void shouldReturnTwoForLimitEqualToTwo() {
        long limit = 2L;

        long result = eulerProblem2.sumOfEvenFibonacciNumbers(limit);

        assertThat(result).isEqualTo(2L);
    }
}
