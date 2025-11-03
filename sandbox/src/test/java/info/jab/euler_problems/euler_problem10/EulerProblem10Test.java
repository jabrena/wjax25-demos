package info.jab.euler_problems.euler_problem10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test suite for Euler Problem 10: Summation of primes
 * 
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 */
@DisplayName("Euler Problem 10 Tests")
class EulerProblem10Test {

    @Test
    @DisplayName("Should return sum of primes below 10 as 17")
    void shouldReturnSumOfPrimesBelow10As17() {
        // Given
        long limit = 10;
        long expected = 17;

        // When
        long result = EulerProblem10.sumOfPrimesBelow(limit);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should return sum of primes below 2,000,000")
    void shouldReturnSumOfPrimesBelow2000000() {
        // Given
        long limit = 2_000_000;

        // When
        long result = EulerProblem10.sumOfPrimesBelow(limit);

        // Then
        assertThat(result).isPositive();
        // The expected answer is 142913828922
        assertThat(result).isEqualTo(142913828922L);
    }

    @Test
    @DisplayName("Should handle edge case of limit 2")
    void shouldHandleEdgeCaseLimit2() {
        // Given
        long limit = 2;
        long expected = 0; // No primes below 2

        // When
        long result = EulerProblem10.sumOfPrimesBelow(limit);

        // Then
        assertThat(result).isEqualTo(expected);
    }
}
