package info.jab.euler.problems.problem8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for Euler Problem 8.
 * 
 * Problem: Find the thirteen adjacent digits in the 1000-digit number that have the greatest product.
 * What is the value of this product?
 */
@DisplayName("Euler Problem 8 Tests")
class EulerProblem8Test {

    private EulerProblem8 solution = new EulerProblem8();

    @Test
    @DisplayName("Should find the greatest product of 13 adjacent digits in the 1000-digit number")
    void shouldFindGreatestProductOf13AdjacentDigits() {
        // When
        long result = solution.findGreatestProductOfAdjacentDigits(13);

        // Then
        assertThat(result).isEqualTo(23514624000L);
    }

    @Test
    @DisplayName("Should find the greatest product of 4 adjacent digits (example from problem)")
    void shouldFindGreatestProductOf4AdjacentDigits() {
        // When
        long result = solution.findGreatestProductOfAdjacentDigits(4);

        // Then
        assertThat(result).isEqualTo(5832L);
    }
}
