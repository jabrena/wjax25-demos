package info.jab.eulerproblems.eulerproblem5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 5.
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
    void shouldFindSmallestDivisibleNumber() {
        // Given
        int upperLimit = 20;
        long expected = 232792560L;

        // When
        long result = eulerProblem5.solve(upperLimit);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should find the smallest number divisible by all numbers from 1 to 10")
    void shouldFindSmallestDivisibleNumberFor10() {
        // Given
        int upperLimit = 10;
        long expected = 2520L; // LCM of 1-10

        // When
        long result = eulerProblem5.solve(upperLimit);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should find the smallest number divisible by all numbers from 1 to 5")
    void shouldFindSmallestDivisibleNumberFor5() {
        // Given
        int upperLimit = 5;
        long expected = 60L; // LCM of 1-5 = 2^2 * 3 * 5

        // When
        long result = eulerProblem5.solve(upperLimit);

        // Then
        assertThat(result).isEqualTo(expected);
    }
}
