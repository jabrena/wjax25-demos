package info.jab.eulerproblems.eulerproblem9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Test suite for Euler Problem 9.
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
    @DisplayName("Should find the Pythagorean triplet with sum 1000 and return the product")
    void shouldFindPythagoreanTripletWithSum1000() {
        // Given
        EulerProblem9 problem = new EulerProblem9();

        // When
        long result = problem.solve();

        // Then
        // The triplet is a=200, b=375, c=425
        // 200 + 375 + 425 = 1000
        // 200? + 375? = 40000 + 140625 = 180625 = 425?
        // Product = 200 * 375 * 425 = 31875000
        assertThat(result).isEqualTo(31875000L);
    }

    @Test
    @DisplayName("Should verify the triplet satisfies Pythagorean theorem")
    void shouldVerifyTripletSatisfiesPythagoreanTheorem() {
        // Given
        EulerProblem9 problem = new EulerProblem9();

        // When
        long product = problem.solve();
        
        // Then - verify the triplet (200, 375, 425) satisfies a? + b? = c?
        int a = 200;
        int b = 375;
        int c = 425;
        
        assertThat(a * a + b * b).isEqualTo(c * c);
        assertThat(a + b + c).isEqualTo(1000);
        assertThat(a * b * c).isEqualTo(product);
    }
}
