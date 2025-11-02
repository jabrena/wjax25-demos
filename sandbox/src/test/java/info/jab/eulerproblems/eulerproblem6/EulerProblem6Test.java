package info.jab.eulerproblems.eulerproblem6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler problem #6: Sum square difference.
 * 
 * Problem: Find the difference between the sum of the squares of the first one hundred 
 * natural numbers and the square of the sum.
 */
@DisplayName("Euler Problem #6 Tests")
class EulerProblem6Test {

    private EulerProblem6 solver;

    @BeforeEach
    void setUp() {
        solver = new EulerProblem6();
    }

    @Test
    @DisplayName("Should calculate difference for first 10 natural numbers")
    void shouldCalculateDifferenceForFirstTenNumbers() {
        // Given
        int n = 10;

        // When
        long result = solver.calculateSumSquareDifference(n);

        // Then
        // Sum of squares: 1? + 2? + ... + 10? = 385
        // Square of sum: (1 + 2 + ... + 10)? = 55? = 3025
        // Difference: 3025 - 385 = 2640
        assertThat(result).isEqualTo(2640L);
    }

    @Test
    @DisplayName("Should calculate difference for first 100 natural numbers")
    void shouldCalculateDifferenceForFirstHundredNumbers() {
        // Given
        int n = 100;

        // When
        long result = solver.calculateSumSquareDifference(n);

        // Then
        // This is the solution to Euler problem #6
        assertThat(result).isEqualTo(25164150L);
    }

    @Test
    @DisplayName("Should handle edge case n=1")
    void shouldHandleEdgeCaseN1() {
        // Given
        int n = 1;

        // When
        long result = solver.calculateSumSquareDifference(n);

        // Then
        // Sum of squares: 1? = 1
        // Square of sum: (1)? = 1
        // Difference: 1 - 1 = 0
        assertThat(result).isEqualTo(0L);
    }

    @Test
    @DisplayName("Should handle edge case n=2")
    void shouldHandleEdgeCaseN2() {
        // Given
        int n = 2;

        // When
        long result = solver.calculateSumSquareDifference(n);

        // Then
        // Sum of squares: 1? + 2? = 1 + 4 = 5
        // Square of sum: (1 + 2)? = 3? = 9
        // Difference: 9 - 5 = 4
        assertThat(result).isEqualTo(4L);
    }
}
