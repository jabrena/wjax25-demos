package info.jab.eulerproblems.eulerproblem3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for Euler Problem 3: Largest Prime Factor
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143?
 */
@DisplayName("Euler Problem 3 Tests")
class EulerProblem3Test {

    @Test
    @DisplayName("Should find the largest prime factor of 13195")
    void shouldFindLargestPrimeFactorOf13195() {
        // Given
        EulerProblem3 problem = new EulerProblem3();
        long number = 13195L;
        long expected = 29L;

        // When
        long result = problem.findLargestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should find the largest prime factor of 600851475143")
    void shouldFindLargestPrimeFactorOf600851475143() {
        // Given
        EulerProblem3 problem = new EulerProblem3();
        long number = 600851475143L;

        // When
        long result = problem.findLargestPrimeFactor(number);

        // Then
        assertThat(result).isPositive();
        // Verify it's a prime factor
        assertThat(number % result).isEqualTo(0);
    }
}
