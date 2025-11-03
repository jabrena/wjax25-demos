package info.jab.euler_problems.euler_problem5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test suite for Euler Problem 5.
 * 
 * Problem statement:
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
@DisplayName("Euler Problem 5 Tests")
class EulerProblem5Test {

    private EulerProblem5 solver = new EulerProblem5();

    @Test
    @DisplayName("Should find smallest number divisible by 1 to 10")
    void shouldFindSmallestNumberDivisibleBy1To10() {
        // Given
        int upperLimit = 10;

        // When
        long result = solver.solve(upperLimit);

        // Then
        assertThat(result).isEqualTo(2520L);
    }

    @Test
    @DisplayName("Should find smallest number divisible by 1 to 20")
    void shouldFindSmallestNumberDivisibleBy1To20() {
        // Given
        int upperLimit = 20;

        // When
        long result = solver.solve(upperLimit);

        // Then
        assertThat(result).isPositive();
        // Verify that the result is divisible by all numbers from 1 to 20
        for (int i = 1; i <= 20; i++) {
            assertThat(result % i).isEqualTo(0L);
        }
    }

    @Test
    @DisplayName("Should handle edge case of 1")
    void shouldHandleEdgeCaseOf1() {
        // Given
        int upperLimit = 1;

        // When
        long result = solver.solve(upperLimit);

        // Then
        assertThat(result).isEqualTo(1L);
    }

    @Test
    @DisplayName("Should handle small numbers")
    void shouldHandleSmallNumbers() {
        // Given
        int upperLimit = 5;

        // When
        long result = solver.solve(upperLimit);

        // Then
        assertThat(result).isEqualTo(60L); // LCM of 1,2,3,4,5
    }
}
