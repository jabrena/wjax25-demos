package info.jab.eulerproblems.eulerproblem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 1.
 * Problem: Find the sum of all the multiples of 3 or 5 below 1000.
 * Example: For numbers below 10, we get 3, 5, 6, 9, and their sum is 23.
 */
@DisplayName("Euler Problem 1 Tests")
class EulerProblem1Test {

    private EulerProblem1 solution;

    @BeforeEach
    void setUp() {
        solution = new EulerProblem1();
    }

    @Test
    @DisplayName("Should return 23 for numbers below 10")
    void shouldReturn23ForNumbersBelow10() {
        // Given
        int limit = 10;

        // When
        long result = solution.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(23);
    }

    @Test
    @DisplayName("Should return 0 for numbers below 3")
    void shouldReturn0ForNumbersBelow3() {
        // Given
        int limit = 3;

        // When
        long result = solution.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Should return 3 for numbers below 5")
    void shouldReturn3ForNumbersBelow5() {
        // Given
        int limit = 5;

        // When
        long result = solution.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("Should return 8 for numbers below 6")
    void shouldReturn8ForNumbersBelow6() {
        // Given
        int limit = 6;

        // When
        long result = solution.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(8); // 3 + 5
    }

    @Test
    @DisplayName("Should return 14 for numbers below 7")
    void shouldReturn14ForNumbersBelow7() {
        // Given
        int limit = 7;

        // When
        long result = solution.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(14); // 3 + 5 + 6
    }

    @Test
    @DisplayName("Should return the correct sum for numbers below 1000")
    void shouldReturnCorrectSumForNumbersBelow1000() {
        // Given
        int limit = 1000;

        // When
        long result = solution.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(233168);
    }
}
