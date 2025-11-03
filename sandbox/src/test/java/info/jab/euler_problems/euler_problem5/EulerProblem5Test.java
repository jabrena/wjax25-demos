package info.jab.euler_problems.euler_problem5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for Euler Problem 5:
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
@DisplayName("Euler Problem 5 Tests")
class EulerProblem5Test {

    @Test
    @DisplayName("Should find the smallest number divisible by 1-10 is 2520")
    void shouldFindSmallestNumberDivisibleBy1To10() {
        // Given
        EulerProblem5 problem5 = new EulerProblem5();

        // When
        long result = problem5.findSmallestDivisible(1, 10);

        // Then
        assertThat(result).isEqualTo(2520L);
    }

    @Test
    @DisplayName("Should find the smallest number divisible by 1-20")
    void shouldFindSmallestNumberDivisibleBy1To20() {
        // Given
        EulerProblem5 problem5 = new EulerProblem5();

        // When
        long result = problem5.findSmallestDivisible(1, 20);

        // Then
        assertThat(result).isPositive();
        assertThat(result).isGreaterThan(2520L);
        
        // Verify it's divisible by all numbers from 1 to 20
        for (int i = 1; i <= 20; i++) {
            assertThat(result % i).isEqualTo(0L);
        }
    }

    @Test
    @DisplayName("Should find the smallest number divisible by 1-5 is 60")
    void shouldFindSmallestNumberDivisibleBy1To5() {
        // Given
        EulerProblem5 problem5 = new EulerProblem5();

        // When
        long result = problem5.findSmallestDivisible(1, 5);

        // Then
        assertThat(result).isEqualTo(60L);
    }
}
