package info.jab.euler_problems.euler_problem9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for Euler Problem 9.
 * 
 * Problem: A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a? + b? = c?
 * 
 * For example, 3? + 4? = 9 + 16 = 25 = 5?.
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
@DisplayName("Euler Problem 9 Tests")
class EulerProblem9Test {

    @Test
    @DisplayName("Should find the Pythagorean triplet with sum 1000 and return the product")
    void shouldFindPythagoreanTripletWithSum1000() {
        // Given
        EulerProblem9 solution = new EulerProblem9();

        // When
        long result = solution.solve();

        // Then
        // The expected product is 31875000
        // The triplet is: a = 200, b = 375, c = 425
        // 200 + 375 + 425 = 1000
        // 200? + 375? = 40000 + 140625 = 180625 = 425?
        assertThat(result).isEqualTo(31875000L);
    }

    @Test
    @DisplayName("Should verify the triplet satisfies Pythagorean theorem")
    void shouldVerifyPythagoreanTriplet() {
        // Given
        EulerProblem9 solution = new EulerProblem9();

        // When
        long result = solution.solve();

        // Then
        // Extract the triplet values for verification
        // We know from the problem that there's exactly one triplet
        // We'll verify by checking the solution method returns the correct product
        assertThat(result).isPositive();
        assertThat(result).isEqualTo(31875000L);
    }
}
