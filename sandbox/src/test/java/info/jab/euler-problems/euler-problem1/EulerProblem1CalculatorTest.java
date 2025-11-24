package info.jab.euler_problems.euler_problem1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class EulerProblem1CalculatorTest {

    @Test
    void should_compute_sum_of_multiples_below_1000() {
        EulerProblem1Calculator calculator = new EulerProblem1Calculator();

        long result = calculator.sumOfMultiplesBelow(1_000);

        assertThat(result).isEqualTo(233_168L);
    }
}
