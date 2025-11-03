package info.jab.euler_problems.euler_problem5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 5.
 * 
 * Problem: What is the smallest positive number that is evenly divisible 
 * by all of the numbers from 1 to 20?
 */
@DisplayName("Euler Problem 5 Tests")
class EulerProblem5Test {

    private EulerProblem5 eulerProblem5;

    @BeforeEach
    void setUp() {
        eulerProblem5 = new EulerProblem5();
    }

    @Test
    @DisplayName("Should find the smallest number divisible by all numbers from 1 to 20")
    void shouldFindSmallestNumberDivisibleByAllNumbersFrom1To20() {
        // Given & When
        long result = eulerProblem5.solve(20);

        // Then
        assertThat(result).isEqualTo(232792560L);
    }

    @Test
    @DisplayName("Should find the smallest number divisible by all numbers from 1 to 10")
    void shouldFindSmallestNumberDivisibleByAllNumbersFrom1To10() {
        // Given & When
        long result = eulerProblem5.solve(10);

        // Then
        assertThat(result).isEqualTo(2520L);
    }

    @Test
    @DisplayName("Should find the smallest number divisible by all numbers from 1 to 5")
    void shouldFindSmallestNumberDivisibleByAllNumbersFrom1To5() {
        // Given & When
        long result = eulerProblem5.solve(5);

        // Then
        assertThat(result).isEqualTo(60L);
    }
}
