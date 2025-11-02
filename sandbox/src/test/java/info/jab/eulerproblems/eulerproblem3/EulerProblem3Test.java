package info.jab.eulerproblems.eulerproblem3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test suite for Euler Problem 3: Largest Prime Factor
 * 
 * Problem statement:
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143?
 */
@DisplayName("Euler Problem 3 Tests")
class EulerProblem3Test {

    private EulerProblem3 problem = new EulerProblem3();

    @Test
    @DisplayName("Should find largest prime factor of 13195")
    void shouldFindLargestPrimeFactorOf13195() {
        // Given
        long number = 13195L;
        
        // When
        long result = problem.findLargestPrimeFactor(number);
        
        // Then
        assertThat(result).isEqualTo(29L);
    }

    @Test
    @DisplayName("Should find largest prime factor of 600851475143")
    void shouldFindLargestPrimeFactorOf600851475143() {
        // Given
        long number = 600851475143L;
        
        // When
        long result = problem.findLargestPrimeFactor(number);
        
        // Then
        assertThat(result).isPositive();
        // Verify it's a factor
        assertThat(number % result).isEqualTo(0L);
    }

    @Test
    @DisplayName("Should handle prime number input")
    void shouldHandlePrimeNumberInput() {
        // Given
        long number = 17L; // A prime number
        
        // When
        long result = problem.findLargestPrimeFactor(number);
        
        // Then
        assertThat(result).isEqualTo(17L);
    }

    @Test
    @DisplayName("Should handle small composite number")
    void shouldHandleSmallCompositeNumber() {
        // Given
        long number = 10L; // 2 * 5
        
        // When
        long result = problem.findLargestPrimeFactor(number);
        
        // Then
        assertThat(result).isEqualTo(5L);
    }
}