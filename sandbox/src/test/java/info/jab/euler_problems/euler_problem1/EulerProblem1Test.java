package info.jab.euler_problems.euler_problem1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EulerProblem1Test {

    @Test
    void should_return_23_for_multiples_below_10() {
        // Given
        EulerProblem1 problem = new EulerProblem1();

        // When
        long result = problem.solve(10);

        // Then
        assertThat(result).isEqualTo(23);
    }

    @Test
    void should_return_sum_for_multiples_below_1000() {
        // Given
        EulerProblem1 problem = new EulerProblem1();

        // When
        long result = problem.solve(1000);

        // Then
        assertThat(result).isEqualTo(233168);
    }
}
