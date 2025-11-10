package info.jab.euler_problems.euler_problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 1.
 * Problem: Find the sum of all the multiples of 3 or 5 below a given number.
 */
@DisplayName("Euler Problem 1 Tests")
class EulerProblem1Test {

    private EulerProblem1 eulerProblem1;

    @BeforeEach
    void setUp() {
        eulerProblem1 = new EulerProblem1();
    }

    @Test
    @DisplayName("Should return correct sum for example case (below 10)")
    void shouldReturnCorrectSumForExampleCase() {
        // Given
        int limit = 10;

        // When
        long result = eulerProblem1.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(23); // 3 + 5 + 6 + 9 = 23
    }

    @Test
    @DisplayName("Should return correct sum for problem case (below 1000)")
    void shouldReturnCorrectSumForProblemCase() {
        // Given
        int limit = 1000;

        // When
        long result = eulerProblem1.sumMultiplesOf3Or5(limit);

        // Then
        assertThat(result).isEqualTo(233168);
    }

    @ParameterizedTest
    @DisplayName("Should return correct sum for various limits")
    @CsvSource({
        "1, 0",
        "3, 0",
        "4, 3",
        "5, 3",
        "6, 8",
        "10, 23",
        "15, 45",
        "20, 78"
    })
    void shouldReturnCorrectSumForVariousLimits(int limit, long expected) {
        long result = eulerProblem1.sumMultiplesOf3Or5(limit);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Should return zero for limit less than 3")
    void shouldReturnZeroForLimitLessThan3() {
        assertThat(eulerProblem1.sumMultiplesOf3Or5(0)).isEqualTo(0);
        assertThat(eulerProblem1.sumMultiplesOf3Or5(1)).isEqualTo(0);
        assertThat(eulerProblem1.sumMultiplesOf3Or5(2)).isEqualTo(0);
    }
}
