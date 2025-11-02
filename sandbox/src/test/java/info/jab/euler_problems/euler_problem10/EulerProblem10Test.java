package info.jab.euler_problems.euler_problem10;

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
    @DisplayName("Should calculate sum of primes below 10 correctly")
    void shouldCalculateSumOfPrimesBelow10() {
        // Given
        long limit = 10;

        // When
        long result = problem.sumOfPrimesBelow(limit);

        // Then
        // Sum of primes below 10: 2 + 3 + 5 + 7 = 17
        assertThat(result).isEqualTo(17);
    }

    @Test
    @DisplayName("Should calculate sum of primes below 2")
    void shouldCalculateSumOfPrimesBelow2() {
        // Given
        long limit = 2;

        // When
        long result = problem.sumOfPrimesBelow(limit);

        // Then
        // No primes below 2
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Should solve Euler Problem 10: sum of primes below two million")
    void shouldSolveEulerProblem10() {
        // Given
        long limit = 2_000_000;

        // When
        long result = problem.sumOfPrimesBelow(limit);

        // Then
        // Verified answer from Project Euler
        assertThat(result).isEqualTo(142913828922L);
    }
}
