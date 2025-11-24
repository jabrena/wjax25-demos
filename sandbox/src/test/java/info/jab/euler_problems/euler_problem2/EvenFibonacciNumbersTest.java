package info.jab.euler_problems.euler_problem2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Project Euler Problem 2 - Even Fibonacci Numbers")
class EvenFibonacciNumbersTest {

    private final FibonacciEvenSumSolver solver = new FibonacciEvenSumSolver();

    @Test
    @DisplayName("Should sum even Fibonacci numbers up to 100")
    void shouldSumEvenFibonacciNumbersUpToOneHundred() {
        long result = solver.sumEvenTermsUpTo(100);
        assertThat(result).isEqualTo(44);
    }

    @Test
    @DisplayName("Should return Project Euler answer for limit 4_000_000")
    void shouldReturnProjectEulerAnswer() {
        long result = solver.sumEvenTermsUpTo(4_000_000);
        assertThat(result).isEqualTo(4_613_732);
    }
}
