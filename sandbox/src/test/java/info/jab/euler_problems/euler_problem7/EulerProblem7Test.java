package info.jab.euler_problems.euler_problem7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test class for Euler Problem 7.
 * Problem statement: What is the 10,001st prime number?
 */
@DisplayName("Euler Problem 7 Tests")
class EulerProblem7Test {

    @Test
    @DisplayName("Should find the 6th prime number correctly")
    void shouldFind6thPrimeNumber() {
        // Given
        EulerProblem7 problem = new EulerProblem7();
        
        // When
        long result = problem.findNthPrime(6);
        
        // Then
        assertThat(result).isEqualTo(13);
    }

    @Test
    @DisplayName("Should find the 1st prime number correctly")
    void shouldFind1stPrimeNumber() {
        // Given
        EulerProblem7 problem = new EulerProblem7();
        
        // When
        long result = problem.findNthPrime(1);
        
        // Then
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("Should find the 10,001st prime number correctly")
    void shouldFind10001stPrimeNumber() {
        // Given
        EulerProblem7 problem = new EulerProblem7();
        
        // When
        long result = problem.findNthPrime(10001);
        
        // Then
        assertThat(result).isEqualTo(104743);
    }
}
