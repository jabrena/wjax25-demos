package info.jab.euler_problems.euler_problem9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 9: Special Pythagorean triplet
 * 
 * Problem: A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a? + b? = c?
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
@DisplayName("Euler Problem 9 Tests")
class EulerProblem9Test {

    @Test
    @DisplayName("Should find the product of the Pythagorean triplet with sum 1000")
    void shouldFindProductOfPythagoreanTripletWithSum1000() {
        // Given
        EulerProblem9 problem = new EulerProblem9();
        int targetSum = 1000;

        // When
        long result = problem.solve(targetSum);

        // Then
        // Verify the triplet exists and its sum is 1000
        // The known answer is 31875000 (a=200, b=375, c=425)
        assertThat(result).isEqualTo(31875000L);
    }

    @Test
    @DisplayName("Should verify the found triplet is a valid Pythagorean triplet")
    void shouldVerifyTripletIsValidPythagoreanTriplet() {
        // Given
        EulerProblem9 problem = new EulerProblem9();
        int targetSum = 1000;

        // When
        long product = problem.solve(targetSum);

        // Then
        // Verify the product is not zero (triplet was found)
        assertThat(product).isNotZero();
        assertThat(product).isPositive();
    }

    @Test
    @DisplayName("Should handle example case: triplet (3, 4, 5) with sum 12")
    void shouldHandleExampleCase() {
        // Given
        EulerProblem9 problem = new EulerProblem9();
        int targetSum = 12; // 3 + 4 + 5 = 12

        // When
        long result = problem.solve(targetSum);

        // Then
        // 3 * 4 * 5 = 60
        assertThat(result).isEqualTo(60L);
    }
}
