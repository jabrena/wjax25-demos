package info.jab.eulerproblems.eulerproblem10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 10.
 * Problem: Find the sum of all the primes below two million.
 */
@DisplayName("Euler Problem 10 Tests")
class EulerProblem10Test {

    private EulerProblem10 problem;

    @BeforeEach
    void setUp() {
        problem = new EulerProblem10();
    }

    @Test
    @DisplayName("Should return correct sum of primes below 10")
    void shouldReturnCorrectSumOfPrimesBelow10() {
        // Given
        int limit = 10;

        // When
        long result = problem.sumOfPrimesBelow(limit);

        // Then
        assertThat(result).isEqualTo(17L); // 2 + 3 + 5 + 7 = 17
    }

    @Test
    @DisplayName("Should return correct sum of primes below 2 million")
    void shouldReturnCorrectSumOfPrimesBelow2Million() {
        // Given
        int limit = 2_000_000;

        // When
        long result = problem.sumOfPrimesBelow(limit);

        // Then
        assertThat(result).isGreaterThan(0L);
        // The expected result for Euler Problem 10
        assertThat(result).isEqualTo(142913828922L);
    }

    @Test
    @DisplayName("Should return 0 for limit below 2")
    void shouldReturnZeroForLimitBelow2() {
        // Given
        int limit = 1;

        // When
        long result = problem.sumOfPrimesBelow(limit);

        // Then
        assertThat(result).isEqualTo(0L);
    }

    @Test
    @DisplayName("Should return 2 for limit of 3")
    void shouldReturnTwoForLimitOf3() {
        // Given
        int limit = 3;

        // When
        long result = problem.sumOfPrimesBelow(limit);

        // Then
        assertThat(result).isEqualTo(2L); // Only prime below 3 is 2
    }
}
