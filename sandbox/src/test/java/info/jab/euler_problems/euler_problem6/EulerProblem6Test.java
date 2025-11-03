package info.jab.euler_problems.euler_problem6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test for Euler Problem 6: Sum square difference
 * 
 * The sum of the squares of the first ten natural numbers is,
 * 1? + 2? + ... + 10? = 385
 * 
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)? = 55? = 3025
 * 
 * Hence the difference between the sum of the squares of the first ten natural numbers 
 * and the square of the sum is 3025 ? 385 = 2640.
 * 
 * Find the difference between the sum of the squares of the first one hundred natural numbers 
 * and the square of the sum.
 */
@DisplayName("Euler Problem 6 Tests")
class EulerProblem6Test {

    @Test
    @DisplayName("Should calculate the difference for first 10 natural numbers")
    void shouldCalculateDifferenceForFirstTenNumbers() {
        // Given
        int n = 10;

        // When
        long result = EulerProblem6.calculateDifference(n);

        // Then
        assertThat(result).isEqualTo(2640L);
    }

    @Test
    @DisplayName("Should calculate the difference for first 100 natural numbers")
    void shouldCalculateDifferenceForFirstHundredNumbers() {
        // Given
        int n = 100;

        // When
        long result = EulerProblem6.calculateDifference(n);

        // Then
        assertThat(result).isEqualTo(25164150L);
    }
}
