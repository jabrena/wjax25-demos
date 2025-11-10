package info.jab.eulerproblems.eulerproblem3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 3: Largest Prime Factor
 * 
 * Problem: What is the largest prime factor of the number 600851475143?
 */
@DisplayName("Euler Problem 3 Tests")
class EulerProblem3Test {

    private EulerProblem3 eulerProblem3;

    @BeforeEach
    void setUp() {
        eulerProblem3 = new EulerProblem3();
    }

    @Test
    @DisplayName("Should find the largest prime factor of 600851475143")
    void shouldFindLargestPrimeFactorOf600851475143() {
        // Given
        long number = 600851475143L;

        // When
        long result = eulerProblem3.largestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(6857L);
    }

    @Test
    @DisplayName("Should find the largest prime factor of 13195")
    void shouldFindLargestPrimeFactorOf13195() {
        // Given
        long number = 13195L;

        // When
        long result = eulerProblem3.largestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(29L);
    }

    @Test
    @DisplayName("Should find the largest prime factor of a prime number")
    void shouldFindLargestPrimeFactorOfPrimeNumber() {
        // Given
        long number = 17L;

        // When
        long result = eulerProblem3.largestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(17L);
    }

    @Test
    @DisplayName("Should find the largest prime factor of a small composite number")
    void shouldFindLargestPrimeFactorOfSmallCompositeNumber() {
        // Given
        long number = 10L;

        // When
        long result = eulerProblem3.largestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(5L);
    }
}
