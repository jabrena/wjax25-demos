package info.jab.euler_problems.euler_problem10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Euler Problem 10 Tests")
class EulerProblem10Test {

    private EulerProblem10 eulerProblem10 = new EulerProblem10();

    @Test
    @DisplayName("Should calculate sum of primes below 10 correctly")
    void shouldCalculateSumOfPrimesBelow10() {
        // Given
        int limit = 10;

        // When
        long result = eulerProblem10.sumOfPrimesBelow(limit);

        // Then
        assertThat(result).isEqualTo(17L); // 2 + 3 + 5 + 7 = 17
    }

    @Test
    @DisplayName("Should calculate sum of primes below 2 million correctly")
    void shouldCalculateSumOfPrimesBelowTwoMillion() {
        // Given
        int limit = 2_000_000;

        // When
        long result = eulerProblem10.sumOfPrimesBelow(limit);

        // Then
        assertThat(result).isEqualTo(142913828922L);
    }
}
