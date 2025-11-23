package info.jab.eulerproblems.eulerproblem1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EulerProblem1Test {

    @Test
    void shouldReturnSumOfMultiplesOf3Or5Below10() {
        // Given
        int limit = 10;
        int expected = 23; // 3 + 5 + 6 + 9

        // When
        int result = EulerProblem1.sumOfMultiples(limit);

        // Then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void shouldReturnSumOfMultiplesOf3Or5Below1000() {
        // Given
        int limit = 1000;

        // When
        int result = EulerProblem1.sumOfMultiples(limit);

        // Then
        assertThat(result).isPositive();
    }
}
