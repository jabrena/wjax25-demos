package info.jab.euler_problems.euler_problem7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for Euler Problem 7: 10001st Prime
 * 
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, 
 * we can see that the 6th prime is 13.
 * 
 * What is the 10,001st prime number?
 */
@DisplayName("Euler Problem 7 Tests")
class EulerProblem7Test {

    @Test
    @DisplayName("Should find the 6th prime number correctly")
    void shouldFindSixthPrimeNumber() {
        // Given
        EulerProblem7 solution = new EulerProblem7();

        // When
        long result = solution.findNthPrime(6);

        // Then
        assertThat(result).isEqualTo(13L);
    }

    @Test
    @DisplayName("Should find the 10,001st prime number correctly")
    void shouldFindTenThousandFirstPrimeNumber() {
        // Given
        EulerProblem7 solution = new EulerProblem7();

        // When
        long result = solution.findNthPrime(10_001);

        // Then
        assertThat(result).isEqualTo(104743L);
    }

    @Test
    @DisplayName("Should find the first prime number correctly")
    void shouldFindFirstPrimeNumber() {
        // Given
        EulerProblem7 solution = new EulerProblem7();

        // When
        long result = solution.findNthPrime(1);

        // Then
        assertThat(result).isEqualTo(2L);
    }

    @Test
    @DisplayName("Should find the second prime number correctly")
    void shouldFindSecondPrimeNumber() {
        // Given
        EulerProblem7 solution = new EulerProblem7();

        // When
        long result = solution.findNthPrime(2);

        // Then
        assertThat(result).isEqualTo(3L);
    }
}
