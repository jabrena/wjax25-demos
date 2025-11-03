package info.jab.euler_problems.euler_problem4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test suite for Euler Problem 4.
 * 
 * Problem: Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * A palindromic number reads the same both ways. The largest palindrome made from 
 * the product of two 2-digit numbers is 9009 = 91 ? 99.
 */
@DisplayName("Euler Problem 4 Tests")
class EulerProblem4Test {

    private final EulerProblem4 solver = new EulerProblem4();

    @Test
    @DisplayName("Should find largest palindrome from product of two 2-digit numbers")
    void shouldFindLargestPalindromeFromTwoDigitNumbers() {
        // Given - example from problem statement
        // The largest palindrome from two 2-digit numbers is 9009 = 91 ? 99
        
        // When
        int result = solver.findLargestPalindrome(2);
        
        // Then
        assertThat(result).isEqualTo(9009);
    }

    @Test
    @DisplayName("Should find largest palindrome from product of two 3-digit numbers")
    void shouldFindLargestPalindromeFromThreeDigitNumbers() {
        // Given
        // When
        int result = solver.findLargestPalindrome(3);
        
        // Then
        // The result should be a palindrome
        assertThat(result).isPositive();
        assertThat(solver.isPalindrome(result)).isTrue();
        
        // The result should be a product of two 3-digit numbers
        assertThat(solver.isProductOfNDigitNumbers(result, 3)).isTrue();
    }
}
