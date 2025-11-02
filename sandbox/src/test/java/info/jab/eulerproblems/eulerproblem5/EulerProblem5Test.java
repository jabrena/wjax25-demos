package info.jab.eulerproblems.eulerproblem5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test class for Euler Problem 5.
 * Problem: What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
@DisplayName("Euler Problem 5 Tests")
class EulerProblem5Test {

    @Test
    @DisplayName("Should return the smallest number divisible by all numbers from 1 to 10")
    void shouldReturnSmallestNumberDivisibleByOneToTen() {
        // Given
        EulerProblem5 problem = new EulerProblem5();

        // When
        long result = problem.solve(10);

        // Then
        assertThat(result).isEqualTo(2520L);
    }

    @Test
    @DisplayName("Should return the smallest number divisible by all numbers from 1 to 20")
    void shouldReturnSmallestNumberDivisibleByOneToTwenty() {
        // Given
        EulerProblem5 problem = new EulerProblem5();

        // When
        long result = problem.solve(20);

        // Then
        assertThat(result).isEqualTo(232792560L);
    }

    @Test
    @DisplayName("Should return the correct result for n=5")
    void shouldReturnCorrectResultForFive() {
        // Given
        EulerProblem5 problem = new EulerProblem5();

        // When
        long result = problem.solve(5);

        // Then
        assertThat(result).isEqualTo(60L);
    }
}
