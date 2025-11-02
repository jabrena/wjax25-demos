package info.jab.eulerproblems.eulerproblem3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Euler Problem 3 Tests")
class EulerProblem3Test {

    @Test
    @DisplayName("Should find the largest prime factor of 13195")
    void shouldFindLargestPrimeFactorOf13195() {
        // Given
        EulerProblem3 solver = new EulerProblem3();
        long number = 13195L;

        // When
        long result = solver.getLargestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(29L);
    }

    @Test
    @DisplayName("Should find the largest prime factor of 600851475143")
    void shouldFindLargestPrimeFactorOf600851475143() {
        // Given
        EulerProblem3 solver = new EulerProblem3();
        long number = 600851475143L;

        // When
        long result = solver.getLargestPrimeFactor(number);

        // Then
        assertThat(result).isEqualTo(6857L);
    }

    @Test
    @DisplayName("Should handle prime numbers correctly")
    void shouldHandlePrimeNumbers() {
        // Given
        EulerProblem3 solver = new EulerProblem3();

        // When & Then
        assertThat(solver.getLargestPrimeFactor(17L)).isEqualTo(17L);
        assertThat(solver.getLargestPrimeFactor(19L)).isEqualTo(19L);
        assertThat(solver.getLargestPrimeFactor(2L)).isEqualTo(2L);
    }

    @Test
    @DisplayName("Should handle composite numbers correctly")
    void shouldHandleCompositeNumbers() {
        // Given
        EulerProblem3 solver = new EulerProblem3();

        // When & Then
        assertThat(solver.getLargestPrimeFactor(10L)).isEqualTo(5L);
        assertThat(solver.getLargestPrimeFactor(15L)).isEqualTo(5L);
        assertThat(solver.getLargestPrimeFactor(100L)).isEqualTo(5L);
    }
}
