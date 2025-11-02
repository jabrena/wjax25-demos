package info.jab.euler_problems.euler_problem5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Euler Problem 5 Tests")
class EulerProblem5Test {

    private EulerProblem5 solver;

    @BeforeEach
    void setUp() {
        solver = new EulerProblem5();
    }

    @Test
    @DisplayName("Should find the smallest number divisible by all numbers from 1 to 20")
    void shouldFindSmallestNumberDivisibleBy1To20() {
        // Given
        int upperBound = 20;

        // When
        long result = solver.solve(upperBound);

        // Then
        assertThat(result).isEqualTo(232792560L);
    }

    @Test
    @DisplayName("Should find the smallest number divisible by all numbers from 1 to 10")
    void shouldFindSmallestNumberDivisibleBy1To10() {
        // Given
        int upperBound = 10;

        // When
        long result = solver.solve(upperBound);

        // Then
        assertThat(result).isEqualTo(2520L);
    }

    @Test
    @DisplayName("Should handle edge case of upperBound = 1")
    void shouldHandleEdgeCaseUpperBound1() {
        // Given
        int upperBound = 1;

        // When
        long result = solver.solve(upperBound);

        // Then
        assertThat(result).isEqualTo(1L);
    }

    @Test
    @DisplayName("Should handle edge case of upperBound = 2")
    void shouldHandleEdgeCaseUpperBound2() {
        // Given
        int upperBound = 2;

        // When
        long result = solver.solve(upperBound);

        // Then
        assertThat(result).isEqualTo(2L);
    }
}
