package info.jab.euler_problems.euler_problem1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test suite for Euler Problem 1.
 * 
 * Problem: If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
@DisplayName("Euler Problem 1 Tests")
class EulerProblem1Test {

    @Test
    @DisplayName("Should return 23 for multiples of 3 or 5 below 10")
    void shouldReturnCorrectSumForExampleCase() {
        // Given
        int limit = 10;
        
        // When
        long result = EulerProblem1.solve(limit);
        
        // Then
        assertThat(result).isEqualTo(23);
    }

    @Test
    @DisplayName("Should return the correct sum for multiples of 3 or 5 below 1000")
    void shouldReturnCorrectSumForProblemCase() {
        // Given
        int limit = 1000;
        
        // When
        long result = EulerProblem1.solve(limit);
        
        // Then
        assertThat(result).isEqualTo(233168);
    }

    @Test
    @DisplayName("Should return 0 for limit less than 3")
    void shouldReturnZeroForSmallLimit() {
        // Given
        int limit = 2;
        
        // When
        long result = EulerProblem1.solve(limit);
        
        // Then
        assertThat(result).isEqualTo(0);
    }
}
