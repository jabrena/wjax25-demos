package info.jab.euler_problems.euler_problem6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test class for Euler Problem 6.
 * Problem: Find the difference between the sum of the squares of the first 
 * one hundred natural numbers and the square of the sum.
 */
@DisplayName("Euler Problem 6 Tests")
class EulerProblem6Test {

    private final EulerProblem6 problem = new EulerProblem6();

    @Test
    @DisplayName("Should calculate the difference for the first 10 natural numbers")
    void shouldCalculateDifferenceForFirstTenNumbers() {
        // Given: First 10 natural numbers
        // Sum of squares: 1? + 2? + ... + 10? = 385
        // Square of sum: (1 + 2 + ... + 10)? = 55? = 3025
        // Expected difference: 3025 - 385 = 2640
        
        // When
        long result = problem.calculateDifference(10);
        
        // Then
        assertThat(result).isEqualTo(2640L);
    }

    @Test
    @DisplayName("Should calculate the difference for the first 100 natural numbers")
    void shouldCalculateDifferenceForFirstHundredNumbers() {
        // Given: First 100 natural numbers
        // This is the actual problem to solve
        
        // When
        long result = problem.calculateDifference(100);
        
        // Then
        // Expected: Square of sum - Sum of squares
        // Square of sum: (1+2+...+100)? = (100*101/2)? = 5050? = 25502500
        // Sum of squares: 1?+2?+...+100? = 100*101*201/6 = 338350
        // Difference: 25502500 - 338350 = 25164150
        assertThat(result).isEqualTo(25164150L);
    }

    @Test
    @DisplayName("Should handle edge case for first natural number")
    void shouldHandleEdgeCaseForFirstNumber() {
        // Given: Only the first natural number (1)
        // Sum of squares: 1? = 1
        // Square of sum: (1)? = 1
        // Expected difference: 1 - 1 = 0
        
        // When
        long result = problem.calculateDifference(1);
        
        // Then
        assertThat(result).isEqualTo(0L);
    }

    @Test
    @DisplayName("Should handle case for first 3 natural numbers")
    void shouldCalculateDifferenceForFirstThreeNumbers() {
        // Given: First 3 natural numbers
        // Sum of squares: 1? + 2? + 3? = 1 + 4 + 9 = 14
        // Square of sum: (1 + 2 + 3)? = 6? = 36
        // Expected difference: 36 - 14 = 22
        
        // When
        long result = problem.calculateDifference(3);
        
        // Then
        assertThat(result).isEqualTo(22L);
    }
}
